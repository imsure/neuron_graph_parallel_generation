package edu.stthomas.gps;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;

/*
 * A simple range partitioner based on the neuron id which is an interger.
 */
public class NeuronIDRangePartitioner extends Partitioner<IntWritable, MultiWritableWrapper> {
	
	/*
	 * Make sure that TotalNumOfNeurons can be divided by NumOfNeuronsPerPartition
	 * to simplify the processing.
	 */
	public final static int TotalNumOfNeurons = 1000;
	public final static int NumOfNeuronsPerPartition = 200;
	
	@Override
	public int getPartition(IntWritable key, MultiWritableWrapper value, int numReduceTasks) {
		/*
		 * The goal is to put neuron 1 to 200 to the reducer 0,
		 * neuron 201 to 400 to reducer 1, and so on.
		 */
		return (key.get() - 1) / NumOfNeuronsPerPartition;
	}
}
