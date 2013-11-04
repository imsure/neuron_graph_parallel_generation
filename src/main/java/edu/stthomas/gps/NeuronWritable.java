package edu.stthomas.gps;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.FloatWritable;

public class NeuronWritable implements WritableComparable<NeuronWritable> {

	public IntWritable id;
	public char type;
	public int time; // In simulation, it is actually the number iteration
	public float param_a, param_b, param_c, param_d;
	public float recovery;
	public float potential;
	public float synaptic_sum;
	public char fired;
	
	public NeuronWritable() {
		id = new IntWritable();
	}
	
	public void write(DataOutput out) throws IOException {
		id.write(out);
		out.writeChar(type);
		out.writeInt(time);
		out.writeFloat(param_a);
		out.writeFloat(param_b);
		out.writeFloat(param_c);
		out.writeFloat(param_d);
		out.writeFloat(recovery);
		out.writeFloat(potential);
		out.writeFloat(synaptic_sum);
		out.writeChar(fired);
	}
	
	public void readFields(DataInput in) throws IOException {
		id.readFields(in);
		type = in.readChar();
		time = in.readInt();
		param_a = in.readFloat();
		param_b = in.readFloat();
		param_c = in.readFloat();
		param_d = in.readFloat();
		recovery = in.readFloat();
		potential = in.readFloat();
		synaptic_sum = in.readFloat();
		fired = in.readChar();
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		NeuronWritable other = (NeuronWritable) obj;
		if (id.equals(other.id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int compareTo(NeuronWritable other) {
		return id.compareTo(other.id);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id.get()).append(',');
		sb.append(type).append(',');
		sb.append(time).append(',');
		sb.append(param_a).append(',');
		sb.append(param_b).append(',');
		sb.append(param_c).append(',');
		sb.append(param_d).append(',');
		sb.append(recovery).append(',');
		sb.append(potential).append(',');
		sb.append(synaptic_sum).append(',');
		sb.append(fired);
		
		return sb.toString();
	}
}
