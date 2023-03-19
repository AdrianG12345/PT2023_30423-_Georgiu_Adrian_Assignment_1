package mvc.models;

import java.util.HashMap;
import java.util.Map;

public class Polynom {

    private Map<Integer,Double> map = new HashMap<>();

    public Polynom() {


    }

    public Polynom(Map<Integer, Double> map) {
        this.map = map;
    }

    public void add(int power, double coeff)
    {
        if(map.containsKey(power))
        {
            double deja = map.get(power);
            map.put(power, deja + coeff);
        }
        else
        {
            map.put(power, coeff);
        }
    }

    public Map<Integer, Double> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Double> map) {
        this.map = map;
    }

    public Polynom addition(Polynom source)
    {
        Polynom result = new Polynom();

            for (Map.Entry<Integer,Double> var : this.getMap().entrySet())
            {
                result.add(var.getKey(), var.getValue());
            }
            for (Map.Entry<Integer,Double> var : source.getMap().entrySet())
            {
                result.add(var.getKey(), var.getValue());
            }

        return result;

    }


}
