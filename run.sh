#!/bin/sh                                                                                                                                             

hadoop fs -rm -r neuron_graph_meta
hadoop fs -rm -r neuron_graph_input
hadoop fs -put neuron_meta neuron_graph_meta

START=$(date +%s)
hadoop jar neuron_input_parallel_generation-1.0.jar edu.stthomas.gps.NeuonInput neuron_graph_meta neuron_graph_input
END=$(date +%s)

TIME_DIFF=$(( $END - $START ))
echo "It took" $TIME_DIFF "seconds to run the Model." > running_time.txt

hadoop fs -libjars neuron_input_parallel_generation-1.0.jar -text neuron_graph_input/part-m-00003 | head -n 1
