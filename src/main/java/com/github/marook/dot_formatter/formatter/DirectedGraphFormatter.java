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
package com.github.marook.dot_formatter.formatter;

import java.io.IOException;
import java.io.Writer;

import com.github.marook.dot_formatter.dom.Edge;
import com.github.marook.dot_formatter.dom.Graph;
import com.github.marook.dot_formatter.dom.Node;

public class DirectedGraphFormatter {
	
	private static final String NEWLINE = "\n";
	
	private void writeNodeDefinition(final Writer out, final Node n) throws IOException{
		out.write(n.getId());
		out.write("[");
		// TODO write attributes
		out.write("];");
		out.write(NEWLINE);
	}
	
	private void writeEdge(final Writer out, final Edge e) throws IOException {
		out.write(e.getFrom().getId());
		out.write("->");
		out.write(e.getTo().getId());
		out.write(";");
		out.write(NEWLINE);
	}
	
	public void format(final Writer out, final Graph g) throws IOException{
		out.write("digraph g {");
		out.write(NEWLINE);
		
		for(final Node n : g.getNodes()){
			writeNodeDefinition(out, n);
		}
		
		for(final Edge e : g.getEdges()){
			writeEdge(out, e);
		}
		
		out.write("}");
		out.write(NEWLINE);
	}

}
