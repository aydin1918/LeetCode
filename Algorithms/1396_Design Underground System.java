/*
* Runtime: 93 ms, faster than 59.48% of Java online submissions for Design Underground System.
* Memory Usage: 53.7 MB, less than 35.25% of Java online submissions for Design Underground System.
*/

class UndergroundSystem {
    
    HashMap<Integer, Travel> client;
    HashMap<String, List<Metro>> map;

    public UndergroundSystem() {
        client = new HashMap();
        map = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        client.put(id, new Travel(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Travel travel = client.get(id);
        map.putIfAbsent(travel.station + stationName, new ArrayList());
        
        map.get(travel.station + stationName).add(new Metro(travel.beginTime, t));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if (!map.containsKey(startStation+endStation)) return 0.0;
        
        List<Metro> list = map.get(startStation+endStation);
        double res = 0d;
        
        for (Metro metro : list){
            res += metro.endTime - metro.beginTime;
        }
        
        return res / list.size();
    }
    
    class Travel {
        String station;
        int beginTime;
        
        public Travel(String station, int beginTime){
            this.station = station;
            this.beginTime = beginTime;
        }
    }
    
    class Metro {
        //String startStation;
        //String endStation;
        int beginTime;
        int endTime;
        
        public Metro(int beginTime, int endTime){
            this.beginTime = beginTime;
            this.endTime = endTime;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
