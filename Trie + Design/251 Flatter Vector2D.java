public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> outIte;
    Iterator<Integer> innerIte; 
    List<List<Integer>> vec; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.size() == 0) return;
        vec = vec2d; 
        outIte = vec.iterator(); 
        innerIte = outIte.next().iterator();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return innerIte.next(); 
    }

    @Override
    public boolean hasNext() {
        if (outIte == null) {
            return false; 
        }
        while (!innerIte.hasNext()) {
            if (!outIte.hasNext()) {
                return false; 
            }
            innerIte = outIte.next().iterator(); 
        }
        return true; 
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */