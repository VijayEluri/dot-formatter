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
package com.github.marook.dot_formatter.dom;

public class Edge {
	
	public Node from;
	
	public Node to;
	
	public Edge(){
	}
	
	public Edge(final Node form, final Node to){
		this.from = form;
		this.to = to;
	}
	
	public Node getFrom() {
		return from;
	}
	
	public void setFrom(Node from) {
		this.from = from;
	}
	
	public Node getTo() {
		return to;
	}
	
	public void setTo(Node to) {
		this.to = to;
	}

}
