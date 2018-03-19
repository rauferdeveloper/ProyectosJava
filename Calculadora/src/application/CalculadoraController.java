package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class CalculadoraController {
	@FXML
	private TextField txResultado;
	@FXML
	private Button btBorrar;
	@FXML
	private Button btDividir;
	@FXML
	private Button btMultiplicar;
	@FXML
	private Button btRestar;
	@FXML
	private Button btSiete;
	@FXML
	private Button btOcho;
	@FXML
	private Button btNueve;
	@FXML
	private Button btSumar;
	@FXML
	private Button btCuatro;
	@FXML
	private Button btCinco;
	@FXML
	private Button btSeis;
	@FXML
	private Button btResultado;
	@FXML
	private Button btUno;
	@FXML
	private Button btDos;
	@FXML
	private Button btTres;
	@FXML
	private Button btCero;
	@FXML
	private Button btPonerPunto;
	
	
	private int opcion=0;
	
	private double total=0;
	private boolean primeravezBotonOperacion=true;
	private String numeroDos="";
	private boolean primeravez=true;

	// Event Listener on Button[#btBorrar].onAction
	@FXML
	public void onActionBorrarTodo(ActionEvent event) {
		total=0;
		opcion=0;
		numeroDos="";
		primeravez=true;
		primeravezBotonOperacion=true;
		txResultado.setText(total+"");

		deshabilitarBotones();
		
	}
	// Event Listener on Button[#btDividir].onAction
	@FXML
	public void onActionDividir(ActionEvent event) {
		if(primeravezBotonOperacion) {
			txResultado.setText(txResultado.getText()+"/");
			primeravezBotonOperacion=false;
			primeravez=false;
			deshabilitarBotones();

		}else {
			total/=Double.parseDouble(numeroDos);
			txResultado.setText(total+"");
			primeravezBotonOperacion=true;
			numeroDos="";

		}
		opcion=4;
	}
	// Event Listener on Button[#btMultiplicar].onAction
	@FXML
	public void onActionMultiplicar(ActionEvent event) {
		if(primeravezBotonOperacion) {
			txResultado.setText(txResultado.getText()+"X");
			primeravezBotonOperacion=false;
			primeravez=false;
			deshabilitarBotones();

		}else {
			total*=Double.parseDouble(numeroDos);
			txResultado.setText(total+"");
			primeravezBotonOperacion=true;
			numeroDos="";

		}
		opcion=3;

	}
	// Event Listener on Button[#btRestar].onAction
	@FXML
	public void onActionRestar(ActionEvent event) {
		if(primeravezBotonOperacion) {
			txResultado.setText(txResultado.getText()+"-");
			primeravezBotonOperacion=false;
			primeravez=false;
			deshabilitarBotones();

		}else {
			total-=Double.parseDouble(numeroDos);
			txResultado.setText(total+"");
			primeravezBotonOperacion=true;
			numeroDos="";
		}
		opcion=2;

	}
	// Event Listener on Button[#btSiete].onAction
	@FXML
	public void onActionMeterNumero(ActionEvent event) {
		String numeroEscrito = ((Button) event.getSource()).getText();
		habilitarBotones();
		
		if(primeravez) {
			if(!txResultado.getText().equals("0.0")) {
				txResultado.setText(txResultado.getText()+numeroEscrito);

			}else {
				txResultado.setText(numeroEscrito);

			}
			total=Double.parseDouble(txResultado.getText());
		}else {
			txResultado.setText(txResultado.getText()+numeroEscrito);
			numeroDos+=numeroEscrito;
			
		}
		
		
		}
	
	// Event Listener on Button[#btSumar].onAction
	@FXML
	public void onActionSumar(ActionEvent event) {
		if(primeravezBotonOperacion) {
			txResultado.setText(txResultado.getText()+"+");
			primeravezBotonOperacion=false;
			primeravez=false;
			deshabilitarBotones();

		}else {
			total+=Double.parseDouble(numeroDos);
			txResultado.setText(total+"");
			primeravezBotonOperacion=true;
			numeroDos="";

		}
		opcion=1;

	}
	
	// Event Listener on Button[#btResultado].onAction
	@FXML
	public void onActionResultado(ActionEvent event) {
		if(!primeravezBotonOperacion) {
			switch (opcion) {
			case 1:
				total+=Double.parseDouble(numeroDos);
				
				break;
			case 2:

				total-=Double.parseDouble(numeroDos);

				break;
			case 3:
				
				total*=Double.parseDouble(numeroDos);

				break;
			case 4:
				total/=Double.parseDouble(numeroDos);

				break;
			default:
				break;
			}
			txResultado.setText(total+"");
			primeravezBotonOperacion=true;
			btResultado.setDisable(true);
			primeravez=true;
			numeroDos="";

		}
		
	}
	
	// Event Listener on Button[#btPonerPunto].onAction
	@FXML
	public void onActionPonerPunto(ActionEvent event) {
		if(primeravez) {
			txResultado.setText(txResultado.getText()+".");

			total=Double.parseDouble(txResultado.getText());

		}else {
			txResultado.setText(txResultado.getText()+".");

			numeroDos+=".";

		}
	}
	private void habilitarBotones() {
		btRestar.setDisable(false);
		btSumar.setDisable(false);
		btDividir.setDisable(false);
		btMultiplicar.setDisable(false);
		btResultado.setDisable(false);

	}
	private void deshabilitarBotones() {
		btRestar.setDisable(true);
		btSumar.setDisable(true);
		btDividir.setDisable(true);
		btMultiplicar.setDisable(true);
		btResultado.setDisable(true);

	}
	
}
