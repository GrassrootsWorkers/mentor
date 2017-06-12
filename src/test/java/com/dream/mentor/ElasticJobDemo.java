package com.dream.mentor;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.script.ScriptJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * Created by Administrator on 2017/5/18.
 */
public class ElasticJobDemo implements SimpleJob {
    @Override
    public void execute(ShardingContext context) {
        System.out.println("content = "+context.getShardingItem());
        System.out.println("jobname = "+context.getJobName());
        switch (context.getShardingItem()) {
            case 0:
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>0");
                break;
            case 1:
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1");
                // do something by sharding item 1
                break;
            case 2:
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2");
                // do something by sharding item 2
                break;
            // case n: ...
        }
    }
}

class JobDemo{
    public static void main(String[]args){
        //new JobScheduler(createRedistryCenter(), createJobConfiguration()).init();
        new JobScheduler(createRedistryCenter(), createScriptJobConfig(),new MyElasticJobListener()).init();
    }
    private static CoordinatorRegistryCenter createRedistryCenter(){
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("192.168.10.146:2181","elastic-job-demo"));
        regCenter.init();
        return regCenter;
    }
    private static LiteJobConfiguration createJobConfiguration(){
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("demoSimpleJobTest","0 0/15 * * * ?",1).build();
        SimpleJobConfiguration simpleJobConfiguration =new SimpleJobConfiguration(simpleCoreConfig,ElasticJobDemo.class.getCanonicalName());
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfiguration).build();
        return simpleJobRootConfig;
    }
    //脚本执行
    public static LiteJobConfiguration createScriptJobConfig(){
        JobCoreConfiguration scriptCoreConfig  = JobCoreConfiguration.newBuilder("scriptJobTest","0 0/5 * * * ?",1).build();
        ScriptJobConfiguration scriptJobConfig = new ScriptJobConfiguration(scriptCoreConfig, "python  C:\\python_test\\list_dir_file_name.py");
        LiteJobConfiguration scriptLitConfig = LiteJobConfiguration.newBuilder(scriptJobConfig).build();
        return scriptLitConfig;
    }
}

class MyElasticJobListener implements ElasticJobListener{

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("before");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("end");
    }
}