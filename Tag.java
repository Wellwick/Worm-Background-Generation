import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.ListIterator;

public class Tag {
    private String tag;
    private LinkedList<SimpleEntry<Tag, Float>> related;
    private int counter;
    public Tag(String word, int num) {
	tag = word;
	related = new LinkedList<SimpleEntry<Tag, Float>>();
	counter = 0;
    }
    
    public String getTag() { return tag; }
    public Tag getRelated(int index) { return related.get(index).getKey(); }
    public Tag getMostRelated() throws NoRelatedTagException {
	SimpleEntry<Tag, Float> best = null;
	ListIterator<SimpleEntry<Tag, Float>> iterator = related.listIterator();
	while (iterator.hasNext()) {
	    SimpleEntry<Tag, Float> next = iterator.next();
	    if (best == null || best.getValue().compareTo(next.getValue()) < 0)
		best = next;
	}
	//if it wasn't set, throw an exception
	if (best == null)
	    throw new NoRelatedTagException();
	    
	return best.getKey();
    }
    public boolean equals(Tag t) {
	return t.getTag().equals(tag);
    }
    
    public boolean addRelatedTag(Tag t, Float degree) {
	//must check that this hasn't already been added, if it has update relation
	ListIterator<SimpleEntry<Tag, Float>> iterator = related.listIterator();
	while (iterator.hasNext()) {
	    SimpleEntry<Tag, Float> next = iterator.next();
	    if (next.getKey().equals(t)) {
		next.setValue(new Float(degree));
		return true;
	    }
	}
	//need to add to end of list
	return related.add(new SimpleEntry<Tag, Float>(t, degree));
    }
    
}