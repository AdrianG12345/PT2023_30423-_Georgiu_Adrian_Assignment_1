package mvc.models;

import java.util.HashMap;
import java.util.Map;

public class Polynom {

    private Map<Integer,Double> map;

    public Polynom() {
        this.map = new HashMap<>();
    }

    public Polynom(Map<Integer, Double> map) {
        this.map = map;
    }

    public void add(int power, double coeff)///adds a Monom to the polynom
    {
        if(map.containsKey(power))
        {
            double deja = map.get(power);
            if (deja + coeff != 0)
                map.put(power, deja + coeff);
            else
                map.remove(power);///daca coeff e null nu mai am nevoie de el
        }
        else
            map.put(power, coeff);
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
    public Polynom integrate()
    {
        Polynom result = new Polynom();

        for (Map.Entry<Integer,Double> var : this.getMap().entrySet())
        {
            result.add(var.getKey() + 1, var.getValue() / (var.getKey() + 1));
        }


        return result;
    }

    public Polynom derivate()
    {
        Polynom result = new Polynom();

        for (Map.Entry<Integer,Double> var : this.getMap().entrySet())
        {
            if (var.getKey() != 0)///daca e zero nu mai am nevoie == nu mai pun in result
                result.add(var.getKey() - 1, var.getValue() * var.getKey());

        }

        return result;
    }
    public Polynom multiply(Polynom source)
    {
        Polynom result = new Polynom();

        for (Map.Entry<Integer,Double> var1 : this.getMap().entrySet())
            for (Map.Entry<Integer,Double> var2 : source.getMap().entrySet())
                result.add(var1.getKey() + var2.getKey(),  var1.getValue() * var2.getValue());

        return result;
    }

    public Polynom subtract(Polynom source)
    {
        Polynom result = new Polynom();

        for (Map.Entry<Integer,Double> var : this.getMap().entrySet())
        {
            result.add(var.getKey(), var.getValue());
        }
        for (Map.Entry<Integer,Double> var : source.getMap().entrySet())
        {
            result.add(var.getKey(), -var.getValue());
        }

        return result;
    }


}
