package org.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * KEYIN:默认情况下，是mr框架所读到的一行文本的其实偏移量，Long，
 * 但是在hadoop中有自己的更精简化的序列化接口，所以不直接用Long，而用LongWritable
 * VALUEIN：默认情况下，是mr框架所读到的一行文本的内容，String，同上，用TEXT
 * KEYOUT:是用户自定义逻辑处理完成之后输出数据中的KEY，在此处是单词，String
 * VALUEOUT:是用户自定义逻辑完成之后输出数据中的value，在此处是单词次数，Integer
 * @author Maibenben
 *
 */

public class MapperDemo extends Mapper<LongWritable, Text, Text, IntWritable>{
	/**
	 * map阶段的业务逻辑就写在自定义的map()方法中
	 * maptask会对每一行数据调用一次我们自定义的map()
	 * */
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//将maptask传过来的文本内容先转换为String
		String line = value.toString();
		//根据空格将这一行分割成单词
		String[] words = line.split(" ");
		
		//将单词输出为<单词，1>
		for(String word:words) {
			context.write(new Text(word), new IntWritable(1));
		}
	}
}
