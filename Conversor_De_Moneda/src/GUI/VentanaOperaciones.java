package GUI;

import java.text.DecimalFormat;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnConvertir;
	private JList lista;
	private JTextField txtResultado;
	private JFormattedTextField cantidadUsuario;

	public VentanaOperaciones() {
		setTitle("CONVERSOR");
		setResizable(false);
		setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 500);
		setLocationRelativeTo(null);
		iniciaComponentes();

	}

	@SuppressWarnings("unchecked")
	public void iniciaComponentes() {

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lista = new JList();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setModel(new AbstractListModel() {
			String[] values = new String[] { "Peso Colombiano a Dólar Estadounidense", "Peso Colombiano a Euro",
					"Peso Colombiano a Libra Esterlina", "Peso Colombiano a Yen Japonés",
					"Peso Colombiano a Dólar Canadiense", "Dólar Estadounidense a Peso Colombiano",
					"Euro a Peso Colombiano", "Libra Esterlina a Peso Colombiano", "Yen Japonés a Peso Colombiano",
					"Dólar Canadiense a Peso Colombiano" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lista.setSelectedIndex(0);
		lista.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lista.setBounds(10, 82, 516, 231);
		contentPane.add(lista);

		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBackground(new Color(204, 255, 204));
		btnConvertir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnConvertir.setBounds(10, 395, 516, 57);
		contentPane.add(btnConvertir);

		txtResultado = new JTextField();
		txtResultado.setForeground(new Color(0, 0, 255));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Berlin Sans FB", Font.BOLD, 35));
		txtResultado.setEditable(false);
		txtResultado.setBounds(10, 324, 516, 60);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);

		cantidadUsuario = new JFormattedTextField();
		cantidadUsuario.setToolTipText("Introduce aqui la cantidad");
		cantidadUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		cantidadUsuario.setColumns(10);
		cantidadUsuario.setBounds(10, 11, 516, 60);
		contentPane.add(cantidadUsuario);
		btnConvertir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			DecimalFormat fd = new DecimalFormat("0.00");

			if (e.getSource() == btnConvertir) {

				double cantidadIngresada = Double.parseDouble(cantidadUsuario.getText());

				String moneda = (String) lista.getSelectedValue();

				double resultado;

				String resultadoFormateado;

				switch (moneda) {

				case "Peso Colombiano a Dólar Estadounidense":

					resultado = cantidadIngresada * 0.0002443739;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Peso Colombiano a Euro":

					resultado = cantidadIngresada * 0.0002263398256;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Peso Colombiano a Libra Esterlina":

					resultado = cantidadIngresada * 0.0001940479749;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Peso Colombiano a Yen Japonés":

					resultado = cantidadIngresada * 0.03567123228;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Peso Colombiano a Dólar Canadiense":

					resultado = cantidadIngresada * 0.0003319614837;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Dólar Estadounidense a Peso Colombiano":

					resultado = cantidadIngresada * 4093.13352292727783424;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Euro a Peso Colombiano":

					resultado = cantidadIngresada * 4418.51280744179433472;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Libra Esterlina a Peso Colombiano":

					resultado = cantidadIngresada * 5153.36835993292308480;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Yen Japonés a Peso Colombiano":

					resultado = cantidadIngresada * 28.0149323668489502720;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				case "Dólar Canadiense a Peso Colombiano":

					resultado = cantidadIngresada * 3013.41010709960261632;
					resultadoFormateado = fd.format(resultado);
					txtResultado.setText(resultadoFormateado);
					break;

				}

			}
		} catch (NumberFormatException a) {

			JOptionPane.showMessageDialog(null, "Solo se permite convertir datos numéricos", "ERROR",
					JOptionPane.ERROR_MESSAGE);

		} catch (Exception a) {

			JOptionPane.showMessageDialog(null, "Ocurre un error", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
