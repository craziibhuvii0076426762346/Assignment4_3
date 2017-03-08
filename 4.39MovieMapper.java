package mapper.demo.movie;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class MovieMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text outkey = new Text();
	IntWritable outValue = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] str = value.toString().split("\t");
		outkey.set(str[0]);
			context.write(outkey, outValue);
		}
	}
