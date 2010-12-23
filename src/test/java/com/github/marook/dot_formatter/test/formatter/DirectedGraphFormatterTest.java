/*
 * Copyright 2010 Markus Pielmeier
 *
 * This file is part of dot-formatter.
 *
 * dot-formatter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * dot-formatter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with dot-formatter.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.marook.dot_formatter.test.formatter;

import java.io.File;
import java.io.FileWriter;

import junit.framework.TestCase;

import com.github.marook.dot_formatter.dom.Edge;
import com.github.marook.dot_formatter.dom.Graph;
import com.github.marook.dot_formatter.dom.Node;
import com.github.marook.dot_formatter.formatter.DirectedGraphFormatter;

public class DirectedGraphFormatterTest extends TestCase {

	private Graph createGraph() {
		final Graph g = new Graph();

		{
			final Node n1 = new Node("n1");
			final Node n2 = new Node("n2");

			{
				final Edge e = new Edge(n1, n2);
				g.getEdges().add(e);
			}
		}

		{
			final Node n3 = new Node("n3");

			g.getNodes().add(n3);
		}

		return g;
	}

	private File getTestFile(final String fileName) {
		final File tmpDir = new File("target/tmp");

		tmpDir.mkdirs();

		return new File(tmpDir, fileName);
	}

	public void testFormat() throws Exception {
		final Graph g = createGraph();

		final File f = getTestFile("graph.dot");
		final FileWriter out = new FileWriter(f);
		try {
			new DirectedGraphFormatter().format(out, g);
		} finally {
			out.close();
		}

		final Process p = Runtime.getRuntime().exec(
				new String[] { "dot", f.toString() });
		assertEquals(0, p.waitFor());
	}

}
