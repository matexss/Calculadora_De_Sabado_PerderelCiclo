package ec.edu.ec.poo.vista;
import ec.edu.ec.poo.modelo.Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class CalculadoraView extends Frame{

    private Calculadora calculadora;
    private Panel panelGeneral;
    private Panel panelSuperior;
    private Panel panelCentral;
    private Panel panelInferior;

    private Label numero1;
    private Label numero2;
    private Label resultado;

    private TextField textFieldNumero1;
    private TextField textFieldNumero2;
    private TextField textFieldResultado;

    private Checkbox checkboxSuma;
    private Checkbox checkboxResta;
    private Checkbox checkboxDivision;
    private Checkbox checkboxMultiplicacion;

    private Button enviarDatos;
    private Button limpiar;

    public CalculadoraView(){
        setTitle("Calculadora del Sabado");
        setSize(500,500);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout(3,1));
        calculadora = new Calculadora();
        //Generamos el paner superior
        panelSuperior = new Panel(new GridLayout(3,2));
        //Creamos las etiquetas
        numero1 = new Label("Numero 1:");
        numero2 = new Label("Numero 2:");
        resultado = new Label("Resultado:");
        //Creamos las cajas de texto
        textFieldNumero1 = new TextField("0",10);
        textFieldNumero2 = new TextField("0",10);
        textFieldResultado = new TextField("0.00",10);
        textFieldResultado.setEditable(false);
        //Agregar elementos al panel
        panelSuperior.setBackground(Color.PINK);
        panelSuperior.add(numero1);
        panelSuperior.add(textFieldNumero1);
        panelSuperior.add(numero2);
        panelSuperior.add(textFieldNumero2);
        panelSuperior.add(resultado);
        panelSuperior.add(textFieldResultado);

        //Generamos panel central
        panelCentral = new Panel(new GridLayout(2,2));
        //Creamos los checkbox
        checkboxSuma = new Checkbox("Suma", false);
        checkboxResta = new Checkbox("Resta", false);
        checkboxDivision = new Checkbox("Division", false);
        checkboxMultiplicacion = new Checkbox("Multiplicacion", false);
        //Agregamos elementos al panel
        panelCentral.add(checkboxSuma);
        panelCentral.add(checkboxResta);
        panelCentral.add(checkboxDivision);
        panelCentral.add(checkboxMultiplicacion);

        //Generamos panel inferios
        panelInferior = new Panel();
        //Creamos los buttons
        enviarDatos = new Button("Enviar datos");
        limpiar = new Button("Limpiar");
        //Agregamos los elementos al panel
        panelInferior.add(enviarDatos);
        panelInferior.add(limpiar);

        //Agregamos los paneles al panelGeneral y mostramos el Frame
        panelGeneral.add(panelSuperior, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        panelGeneral.add(panelInferior, BorderLayout.SOUTH);
        add(panelGeneral);
        setVisible(true);

        //Agregar los listener
        checkboxSuma.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarChecbox((Checkbox) e.getSource());
            }
        });

        checkboxResta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarChecbox((Checkbox) e.getSource());
            }
        });

        checkboxDivision.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarChecbox((Checkbox) e.getSource());
            }
        });

        checkboxMultiplicacion.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarChecbox((Checkbox) e.getSource());
            }
        });
        enviarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkboxSuma.getState() == true){
                    suma();
                }
                if (checkboxResta.getState() == true){
                    resta();
                }
                if (checkboxDivision.getState() == true){
                    dividir();
                }
                if (checkboxMultiplicacion.getState() == true){
                    multiplicacion();
                }
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNumero1.setText("");
                textFieldNumero2.setText("");
                textFieldResultado.setText("");
                // Desmarcar todos los checkboxes
                checkboxSuma.setState(false);
                checkboxResta.setState(false);
                checkboxDivision.setState(false);
                checkboxMultiplicacion.setState(false);

                // Habilitar todos los checkboxes (por si estaban deshabilitados)
                checkboxSuma.setEnabled(true);
                checkboxResta.setEnabled(true);
                checkboxDivision.setEnabled(true);
                checkboxMultiplicacion.setEnabled(true);
            }
        });

    }

    public void validarChecbox(Checkbox checkbox){
        if(checkbox.getState() == true && checkbox.getLabel().equals("Sumar")){
            checkboxResta.setEnabled(false);
            checkboxDivision.setEnabled(false);
            checkboxMultiplicacion.setEnabled(false);
        }
        if (checkbox.getState() == true && checkbox.getLabel().equals("Resta")) {
            checkboxSuma.setEnabled(false);
            checkboxDivision.setEnabled(false);
            checkboxMultiplicacion.setEnabled(false);

        }
        if (checkbox.getState() == true && checkbox.getLabel().equals("Division")) {
            checkboxSuma.setEnabled(false);
            checkboxResta.setEnabled(false);
            checkboxMultiplicacion.setEnabled(false);
        }
        if (checkbox.getState() == true && checkbox.getLabel().equals("Multiplicacion")) {
            checkboxSuma.setEnabled(false);
            checkboxResta.setEnabled(false);
            checkboxDivision.setEnabled(false);
        }
    }

    public void suma(){
        double numero1 = Double.parseDouble(textFieldNumero1.getText());
        double numero2 = Double.parseDouble(textFieldNumero2.getText());

        calculadora.setNumero1(numero1);
        calculadora.setNumero2(numero2);
        double resultado = calculadora.sumar();
        textFieldResultado.setText(String.valueOf(resultado));
    }

    public void resta(){
        double numero1 = Double.parseDouble(textFieldNumero1.getText());
        double numero2 = Double.parseDouble(textFieldNumero2.getText());

        calculadora.setNumero1(numero1);
        calculadora.setNumero2(numero2);
        double resultado = calculadora.restar();
        textFieldResultado.setText(String.valueOf(resultado));
    }

    public void dividir(){
        double numero1 = Double.parseDouble(textFieldNumero1.getText());
        double numero2 = Double.parseDouble(textFieldNumero2.getText());

        calculadora.setNumero1(numero1);
        calculadora.setNumero2(numero2);

        if (calculadora.getNumero2()== 0){
            textFieldResultado.setText("Denominador no puede ser 0");
        } else{
            double resultado = calculadora.dividir();
            textFieldResultado.setText(String.valueOf(resultado));
        }

    }

    public void multiplicacion(){
        double numero1 = Double.parseDouble(textFieldNumero1.getText());
        double numero2 = Double.parseDouble(textFieldNumero2.getText());

        calculadora.setNumero1(numero1);
        calculadora.setNumero2(numero2);
        double resultado = calculadora.multiplicar();
        textFieldResultado.setText(String.valueOf(resultado));
    }

}