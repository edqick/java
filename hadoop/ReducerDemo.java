package org.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * KEYIN,VALUEIN 对应 mapper输出的KEYOUT,VALUEOUT类型
 * KEYOUT，VALUEOUT是自定义的reduce逻辑处理结果的输出数据类型
 * KEYOUT是单词，VALUEOUT是总次数
 * @author Maibenben
 *
 */
public class ReducerDemo extends Reducer<Text, IntWritable, Text, IntWritable>{
	/**
	 * <hello,1><hello,1><hello,1><hello,1><hello,1><hello,1><hello,1>
	 * <world,1><world,1><world,1><world,1><world,1><world,1><world,1>
	 * */
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		int count = 0;
		for(IntWritable value:values) {
			count += value.get();
		}
		context.write(key, new IntWritable(count));
	}
}
