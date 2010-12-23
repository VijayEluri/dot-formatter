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
package com.github.marook.dot_formatter.test.dom;

import junit.framework.TestCase;

import com.github.marook.dot_formatter.dom.Node;

public class NodeTest extends TestCase {

	private static final String VALID_ID = "node";

	public void testSetIdValid() {
		for (final String id : new String[] { "1", "bla", "_" }) {
			{
				final Node n = new Node(id);
				assertEquals(id, n.getId());
			}

			{
				final Node n = new Node(VALID_ID);
				n.setId(id);
				assertEquals(id, n.getId());
			}
		}
	}

	public void testSetIdInvalid() {
		for (final String id : new String[] { "", " ", "\t" }) {
			try{
				new Node(id);
				fail("Was able to set illegal ID: " + id);
			}
			catch(final IllegalArgumentException e){
				// test successful
			}

			try{
				final Node n = new Node(VALID_ID);
				n.setId(id);
				
				fail("Was able to set illegal ID: " + id);
			}
			catch(final IllegalArgumentException e){
				// test successful
			}
		}
	}

}
