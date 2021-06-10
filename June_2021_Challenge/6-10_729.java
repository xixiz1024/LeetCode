// 729. My Calendar I

// TreeMap 

class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm=new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer gre=tm.ceilingKey(start), // least greater or equal than start
                les = tm.floorKey(start);// greatest less or equal than start 
        if((les!=null && tm.get(les)>start) || (gre!=null&&gre<end))
            return false;
        tm.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */