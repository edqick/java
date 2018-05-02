package org.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 相当于一个yarn集群的客户端
 * 需要再次封装我们的mr程序的相关运行参数，指定jar包最后提交给yarn
 * @author Maibenben
 */

public class DriverDemo {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
//		conf.set("mapreduce.framework.name", "yarn");
//		conf.set("yarn.resourcemanager.hostname", "hadoop1");
		Job job = Job.getInstance(conf);
//		job.setJar("/home/hadoop/wc.jar");
		job.setJarByClass(DriverDemo.class);
		//指定本业务job要使用的mapper/reducer业务类
		job.setMapperClass(MapperDemo.class);
		job.setReducerClass(ReducerDemo.class);
		//指定mapper输出类型的kv类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		//指定最终输出的数据的kv类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		//指定job的输入原始文件所在目录
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		//指定job的输出结果文件所在目录
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//将job中配置的相关参数，以及job所用的java类所在的jar包，提交给yarn运行
//		job.submit();
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
		
		
	}

}
