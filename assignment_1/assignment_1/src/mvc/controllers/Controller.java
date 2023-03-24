package mvc.controllers;

import mvc.models.Polynom;
import mvc.views.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private ViewFrame view;
    private Polynom polynom1, polynom2;
    private Polynom result;




    public Controller(ViewFrame view)
    {
        this.view = view;
       // this.view.addShowListener(new ShowListener());

        this.view.addCreateListener(new AdditionListener());
        this.view.subtractCreateListener(new SubtractListener());
        this.view.multiplyCreateListener(new MultiplyListener());
        this.view.divideCreateListener(new DivideListener());
        this.view.integrateCreateListener(new IntegrateListener());
        this.view.derivateCreateListener(new DerivateListener());

    }
    class IntegrateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            read();

            result = polynom1.integrate();

            String rezultat = new String();
            rezultat = transformareRezultat();


            view.setResultTextArea(rezultat + "+C");
        }
    }
    class DerivateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            read();

            result = polynom1.derivate();

            String rezultat = new String();
            rezultat = transformareRezultat();

            view.setResultTextArea(rezultat);
        }
    }
    class DivideListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///aici se pune codul cand este apasat butonul respectiv
            //System.out.println("NU ESTE IN BUGET");
            view.showMessage("NU ESTE IN BUGET");
        }
    }
    class MultiplyListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            read();

            result = polynom1.multiply(polynom2);

            String rezultat = new String();
            rezultat = transformareRezultat();

            view.setResultTextArea(rezultat);
        }
    }
    class SubtractListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            read();

            result = polynom1.subtract(polynom2);

            String rezultat = new String();
            rezultat = transformareRezultat();

            view.setResultTextArea(rezultat);
        }
    }
    class AdditionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            read();
            ///adun polinoamele
            result = polynom1.addition(polynom2);
            /*
            for (Map.Entry<Integer,Double> var : polynom1.getMap().entrySet())
            {
                result.add(var.getKey(), var.getValue());
            }
            for (Map.Entry<Integer,Double> var : polynom2.getMap().entrySet())
            {
                result.add(var.getKey(), var.getValue());
            }

            */
            String afisat = new String();
            afisat = transformareRezultat();

            view.setResultTextArea(afisat);
            //System.out.println(afisat);
        }
    }

    /*
    class ShowListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println("am apasat butonul SHOW");
            ///ce se intampla cand apasam show
            view.setCandiesText(shop.getCandies().toString());

        }
    }*/
    String transformareRezultat()
    {
        String afisat = new String();

        for (Map.Entry<Integer,Double> var : result.getMap().entrySet())
        {
            if (var.getKey() == 1)
                afisat = var.getValue() + "x" + afisat;
            else if (var.getKey() != 0)
                afisat = var.getValue() + "x^" + var.getKey() + afisat;
            else
                afisat = var.getValue() + afisat;

            if (var.getValue() > 0)
                afisat = "+" + afisat;
        }

        if (afisat.length() == 0)
            return "0";

        if (afisat.charAt(0) == '+')
        {
            StringBuilder stringBuilder = new StringBuilder(afisat);
            stringBuilder.deleteCharAt(0);
            String newString = stringBuilder.toString();

            return newString;
        }

        return afisat;
    }
    void read()
    {
        this.polynom1 = new Polynom();
        this.polynom2 = new Polynom();

        String sir1 = this.view.getFirstTextField();
        String sir2 = this.view.getSecondTextField();

        ///deci inlocuiesc toate caracterele '-' cu "+-"
        ///astfel incat cand dai split cu '+' imi vor ramane minusurile
        ///la inceput de string
        /// 5x-7 => 5x+-7 => 5x si -7
        List<String> lista1 = new ArrayList<>();
        lista1.addAll(List.of(sir1.replace("-","+-").split("[+]")));

        List<String> lista2 = new ArrayList<>();
        lista2.addAll(List.of(sir2.replace("-","+-").split("[+]")));


        for (String v : lista1)
        {
            ///de verificat cand incep cu - sa nu fie null

            int pow;
            double coeff;

            if (v.length() > 0)
            {
                if(v.equals("x"))
                {
                    pow=1;
                    coeff=1;
                }
                else if(v.equals("-x")){
                    pow = 1;
                    coeff=-1;
                }
                else if (!v.contains("x"))
                {
                    pow = 0;
                    coeff =  Double.parseDouble(v);
                }
                else {
                    List<String> intermediar = new ArrayList<>();
                    intermediar.addAll(List.of(v.split("[x^]")));


                    if (intermediar.size() == 1) {
                        pow = 1;


                    } else {
                        pow = Integer.parseInt(intermediar.get(2));

                    }
                    if (intermediar.get(0) == "")
                        coeff = 1;
                    else
                        coeff = Double.parseDouble(intermediar.get(0));
                }


                polynom1.add(pow, coeff);
            }
        }

        for (String v : lista2)
        {
            ///de verificat cand incep cu - sa nu fie null

            int pow;
            double coeff;

            if (v.length() > 0)
            {
                if(v.equals("x"))
                {
                    pow=1;
                    coeff=1;
                }
                else if(v.equals("-x")){
                    pow = 1;
                    coeff=-1;
                }
                else if (!v.contains("x"))
                {
                    pow = 0;
                    coeff =  Double.parseDouble(v);
                }
                else {
                    List<String> intermediar = new ArrayList<>();
                    intermediar.addAll(List.of(v.split("[x^]")));


                    if (intermediar.size() == 1) {
                        pow = 1;


                    } else {
                        pow = Integer.parseInt(intermediar.get(2));

                    }
                    if (intermediar.get(0) == "")
                        coeff = 1;
                    else
                        coeff = Double.parseDouble(intermediar.get(0));
                }


                polynom2.add(pow, coeff);
            }
        }

        /*
        for (Map.Entry<Integer,Double> e : polynom1.getMap().entrySet())
        {
            System.out.println(e.getKey() + "   " + e.getValue());
        }*/
    }

    

}
