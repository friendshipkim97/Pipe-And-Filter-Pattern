/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package framework;

import java.io.EOFException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class CommonFilterImpl implements CommonFilter {
	protected ArrayList<PipedInputStream> in = new ArrayList<>(Arrays.asList(new PipedInputStream(), new PipedInputStream()));
	protected ArrayList<PipedOutputStream> out = new ArrayList<>(Arrays.asList(new PipedOutputStream(), new PipedOutputStream()));

	public void connectOutputTo(CommonFilter nextFilter, int portNo) throws IOException {
		out.get(portNo).connect(nextFilter.getPipedInputStream(portNo));
	}
	public void connectInputTo(CommonFilter previousFilter, int portNo) throws IOException {
		in.get(portNo).connect(previousFilter.getPipedOutputStream(portNo));
	}
	public PipedInputStream getPipedInputStream(int portNo) {
		return in.get(portNo);
	}
	public PipedOutputStream getPipedOutputStream(int portNo) {
		return out.get(portNo);
	}
	
	abstract public boolean specificComputationForFilter() throws IOException;
	// Implementation defined in Runnable interface for thread
	public void run() {
		try {
			specificComputationForFilter();
		} catch (IOException e) {
			if (e instanceof EOFException) return;
			else System.out.println(e);
		} finally {
			closePorts();
		}
	}
	private void closePorts() {
		try {
			out.get(0).close();
			in.get(0).close();
			out.get(1).close();
			in.get(1).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
