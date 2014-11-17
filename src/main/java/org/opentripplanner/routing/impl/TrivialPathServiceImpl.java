/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.routing.impl;

import java.util.Collections;
import java.util.List;

import jj2000.j2k.NotImplementedError;

import org.opentripplanner.routing.algorithm.GenericAStar;
import org.opentripplanner.routing.core.RoutingRequest;
import org.opentripplanner.routing.services.GraphService;
import org.opentripplanner.routing.services.PathService;
import org.opentripplanner.routing.spt.GraphPath;
import org.opentripplanner.routing.spt.ShortestPathTree;

public class TrivialPathServiceImpl implements PathService {

    GraphService graphService;

    public TrivialPathServiceImpl(GraphService graphService) {
        this.graphService = graphService;
    }

    @Override
    public List<GraphPath> getPaths(RoutingRequest options) {
        ShortestPathTree spt = new GenericAStar().getShortestPathTree(options);
        if (spt == null) {
            return Collections.emptyList();
        }
        return spt.getPaths();
    }

	@Override
	public void setSPTVisitor(SPTVisitor vis) {
		throw new NotImplementedError();
	}
}
