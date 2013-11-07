package edu.stthomas.gps;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;

public class NeuronIDRangePartitioner extends Partitioner<IntWritable, MultiWritableWrapper> {
	
	public final static int TotalNumOfNeurons = 1000;
	public final static int NumOfNeuronsPerPartition = 200;
	
	@Override
	public int getPartition(IntWritable key, MultiWritableWrapper value, int numReduceTasks) {
		return (key.get() - 1) / NumOfNeuronsPerPartition;
	}
}
