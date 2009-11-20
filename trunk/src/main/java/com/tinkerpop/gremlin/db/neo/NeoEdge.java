package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.api.core.Relationship;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoEdge extends NeoElement implements Edge {

    public NeoEdge(Relationship relationship) {
        super(relationship.getId());
        this.element = relationship;
    }

    public String getLabel() {
        return ((Relationship) this.element).getType().name();
    }

    public Vertex getVertex(Vertex.Direction direction) {
        if (direction == Direction.OUT)
            return new NeoVertex(((Relationship) this.element).getStartNode());
        else
            return new NeoVertex(((Relationship) this.element).getEndNode());
    }
}
