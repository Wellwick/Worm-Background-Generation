import java.util.AbstractMap.SimpleEntry;

public class Tag implements  {
    private String tag;
    private SimpleEntry<Tag, Float>[] related;
    private int counter;
    public Tag(String word, int num) {
	tag = word;
	related = new SimpleEntry<Tag, Float>[num];
	counter = 0;
    }
    
    public String getTag() { return tag; }
    public Tag getRelated(int index) { return related[index].getKey(); }
    public Tag getMostRelated() {
	int best = -1;
	for (int i=0; i<counter; i++) {
	    if (best == -1 || related[best].getValue() < related[i].getValue())
		best = i;
	}
	if (best == -1)
	    throw new NoRelatedTagException();
	return related[best].getKey();
    }
    public boolean equals(Tag t) {
	return t.getTag().equals(tag);
    }
    
    public boolean addRelatedTag(Tag t, Float degree) {
	//must check that this hasn't already been added, if it has update relation
	for (int i=0; i<counter; i++) {
	    if (related[i].getKey().equals(t)) {
		related[i].setValue(degree);
		return true; 
	    }
	}
	//need to add to end of list
	try {
	    related[counter] = new SimpleEntry(t, degree);
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.err.println("Tried to add too many related tags to tag " + tag);
	}
    }
    
}