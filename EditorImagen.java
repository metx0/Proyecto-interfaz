/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.imagen;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alemigdiez
 */
public class EditorImagen extends javax.swing.JFrame {

    // Esta es la imagen actual que se despliega en el label
    private ImageIcon currentImage;

    // El archivo correspondiente a dicha imagen
    // imgFile se inicializa cuando se abre una imagen y cuando se "guarda como"
    // El método guardar guarda la imagen obtenida del label en imgFile
    // Al inicio, no existe imgFile ya que, aunque label sí tenga una imagen, esta no se ha almacenado en memoria, por lo que no existe
    private File imgFile;

    // Este es el punto actual donde pasa el mouse para dibujar con el pincel
    private Point prevPoint;

    // Coordenadas iniciales de la línea.
    private int x1, y1;

    // Para evitar conflictos con el mouse listener de las herramientas
    private MouseAdapter currentMouseListener;
    
    // Aquí se guardará la imagen modificada
    // private BufferedImage modifiedImage;

    /**
     * Creates new form EditorImagen
     */
    public EditorImagen() {
        initComponents();
        setLayout(new BorderLayout());

        Color c = new Color(244, 250, 255);
        getContentPane().setBackground(c); // Establecemos el color de fondo del JFrame

        // La ventana ocupa todo el tamaño de la pantalla
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("File 8 Image Editor"); // Establecemos el título de la ventana
        setLocationRelativeTo(null); // Centramos la ventana

        panelHerramientas.setVisible(true); // Mostramos el panel de herramientas

        // Hacemos que el JLabel "labelImage" sea blanco
        labelImage.setOpaque(true);
        labelImage.setBackground(Color.WHITE);
        labelImage.setSize(1200, 720);

        // Al inicio, el label tendrá de ícono un fondo blanco y currentImage es dicha imagen
        labelImage.setIcon(new ImageIcon(getClass().getResource("/iconos/white_cover.jpg")));
        currentImage = (ImageIcon) labelImage.getIcon();

        // Tenemos que reescalar la imagen al ancho y alto del label, ya que la imagen original es de 1920*1080
        // Se podría cambiar dicha imagen tal cual, pero lo haremos manualmente
        // Es algo redundante, pero funciona
        Image img = currentImage.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
        // Asignamos la imagen al label
        labelImage.setIcon(new ImageIcon(img));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImage = new javax.swing.JLabel();
        panelHerramientas = new javax.swing.JPanel();
        btnEscalar = new javax.swing.JButton();
        btnPintar = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemNuevo = new javax.swing.JMenuItem();
        menuItemAbrir = new javax.swing.JMenuItem();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuItemGuardarComo = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelImage.setBackground(new java.awt.Color(255, 255, 254));
        labelImage.setForeground(new java.awt.Color(255, 255, 255));
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/white_cover.jpg"))); // NOI18N
        labelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        panelHerramientas.setBackground(new java.awt.Color(244, 250, 255));

        btnEscalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/escalar.jpg"))); // NOI18N
        btnEscalar.setToolTipText("");
        btnEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalarActionPerformed(evt);
            }
        });

        btnPintar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/paint_brush_icon.png"))); // NOI18N
        btnPintar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPintarActionPerformed(evt);
            }
        });

        btnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icono_linea.png"))); // NOI18N
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHerramientasLayout = new javax.swing.GroupLayout(panelHerramientas);
        panelHerramientas.setLayout(panelHerramientasLayout);
        panelHerramientasLayout.setHorizontalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEscalar)
                    .addComponent(btnPintar)
                    .addComponent(btnLinea))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelHerramientasLayout.setVerticalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEscalar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPintar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLinea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");

        menuItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemNuevo.setText("Nuevo");
        menuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemNuevo);

        menuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemAbrir.setText("Abrir");
        menuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemAbrir);

        menuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemGuardar.setText("Guardar");
        menuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardar);

        menuItemGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemGuardarComo.setText("Guardar como");
        menuItemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarComoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardarComo);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemSalir);

        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(874, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // El método abre una imagen con un JFileChoser y la despliega en el label "labelImage"
    private void menuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirActionPerformed
        // Creamos la instancia del JFileChoser
        JFileChooser fileChooser = new JFileChooser();

        // Crearemos un filtro para el fileChooser con la clase FileNameExtensionFilter
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png");
        // Establecemos el filtro 
        fileChooser.setFileFilter(filtro);

        // Lo abrimos en modalidad Open y guardamos el valor de retorno
        int valorRetorno = fileChooser.showOpenDialog(null);

        // Si el valor de retorno corresponde a "approve_option" quiere decir que se seleccionó un archivo
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            // Guardamos la ruta seleccionada en un objeto File
            imgFile = fileChooser.getSelectedFile();

            // Creamos un objeto ImageIcon a partir de la ruta seleccionada
            // imgSeleccionada.getAbsolutePath() se refiere a la ruta general del archivo en el file system
            // En este caso, el constructor de imgIcon toma de parámetro la ruta absoluta del archivo
            currentImage = new ImageIcon(imgFile.getAbsolutePath());
            
            // Creamos un objeto Image para poder manipular la imagen
            // getImage() obtiene la imagen de currentImage
            // getScaledInstance() se usa para escalar la imagen según el ancho y alto del labelImage, el cual es el 
            // elemento en el que desplegaremos la imagen
            Image img = currentImage.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);

            // Asignamos la imagen al label
            labelImage.setIcon(new ImageIcon(img));
            
            /*// Lo siguiente es para inicializar modifiedImage y poder tenerlo con la imagen que despliega el label
            
            // Obtenemos el icono del label "labelImage"
            Icon icon = labelImage.getIcon();
            
            // Se inicializa modifiedImage
            modifiedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            
            Graphics g = modifiedImage.createGraphics();
            icon.paintIcon(null, g, 0, 0); // Se "pinta" el icono en g
            g.dispose();*/

            // Nota: podemos crear objetos ImageIcon a partir de objetos Image, la cual es otra clase para manipular imágenes
        }
    }//GEN-LAST:event_menuItemAbrirActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        // Salimos del programa
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    // Este método escala la imagen según el ancho y el alto introducido mediante un JOptionPane
    private void btnEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscalarActionPerformed
        // Tenemos que validar los datos. Los datos son inválidos si son menores o iguales a 0, o si exceden determinada cantidad
        // Dicha cantidad depende del tamaño de la interfaz
        // Manejamos la excepción NumberFormatException, la cual ocurre si el usuario introduce algo que no se puede convertir a entero        

        // Límites marcados según el tamaño de la interfaz
        int limiteAncho = 1200;
        int limiteAlto = 720;

        boolean anchoCorrecto = false; // Este booleano es para llevar el control de las excepciones
        int ancho = 0;

        // Para el ancho:
        while (anchoCorrecto != true || ancho <= 0 || ancho > limiteAncho) {
            // Pedimos el ancho y lo guardamos en input
            String input = JOptionPane.showInputDialog("Ingrese el nuevo ancho de la imagen");

            if (input == null) { // Si se presiona "Cancelar" o la "X", finalizamos
                return;
            }

            try {
                ancho = Integer.parseInt(input); // Lo intentamos castear a entero

                if (ancho <= 0 || ancho > limiteAncho) { // Un mensaje para valor no permitidos
                    JOptionPane.showMessageDialog(null, "Valor no permitido para el ancho");
                }

                anchoCorrecto = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor numérico inválido");
                anchoCorrecto = false;
            }
        }

        boolean altoCorrecto = false;
        int alto = 0;

        // Para el alto:
        while (altoCorrecto != true || alto <= 0 || alto > limiteAlto) {
            // Pedimos el alto y lo guardamos en input
            String input = JOptionPane.showInputDialog("Ingrese el nuevo alto de la imagen");

            if (input == null) { // Si se presiona "Cancelar" o la "X", finalizamos
                return;
            }

            try {
                alto = Integer.parseInt(input); // Lo intentamos castear a entero

                if (alto <= 0 || alto > limiteAlto) {
                    JOptionPane.showMessageDialog(null, "Valor no permitido para el alto");
                }

                altoCorrecto = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor numérico inválido");
                altoCorrecto = false;
            }

        }

        // Ya teniendo el ancho y el alto, procedemos a escalar y mostrar la imagen
        // Creamos un objeto Image a partir de currentImage. Esto es para poder manipularla con getScaledInstance()
        Image img = this.currentImage.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        // La mostramos en el label
        labelImage.setSize(ancho, alto);
        labelImage.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_btnEscalarActionPerformed

    // Este método guarda los cambios hechos en el archivo
    private void menuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarActionPerformed
        // Comprobamos que imgFile ya esté inicializado
        // Al inicio, este método no se puede ejecutar, ya que imgFile solo es inicializado con el método
        // abrir y guardar como
        if (imgFile != null) {
            // Tenemos que recuperar la imagen actual del JLabel "labelImage"
            // Obtenemos el icono del label "labelImage"
            Icon icon = labelImage.getIcon();

            // Se crea un objeto BufferedImage a partir de la imagen contenido en icon, usando el método getImage()
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();

            // Guardamos la imagen en el archivo ya existente
            try {
                ImageIO.write(image, "jpg", imgFile);
                JOptionPane.showMessageDialog(this, "Imagen guardada exitosamente");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo");
            }
        }
    }//GEN-LAST:event_menuItemGuardarActionPerformed

    // Este método crea un nuevo archivo con el nombre introducido por el usuario y guarda la imagen en él
    // Igual puede guardar la imagen en un archivo ya existente, usando el mismo nombre del archivo
    private void menuItemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarComoActionPerformed
        // Todo el código solo se ejecuta si ya la imagen está mostrada, es decir, currentImage no es null

        // Creamos el JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Creamos un filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png");
        fileChooser.setFileFilter(filtro);

        int opcion = fileChooser.showSaveDialog(this);

        // Si el usuario pulsó "aceptar"
        if (opcion == JFileChooser.APPROVE_OPTION) {
            // Se obtiene el archivo seleccionado
            imgFile = fileChooser.getSelectedFile();

            // Verificamos si el nombre del archivo ya tiene la extensión ".jpg"
            if (!imgFile.getName().endsWith(".jpg")) {
                // Agregamos la extensión ".jpg" al nombre del archivo
                imgFile = new File(imgFile.getAbsolutePath() + ".jpg");
            }

            // Obtenemos el icono del label "labelImage"
            Icon icon = labelImage.getIcon();

            // Se crea un objeto BufferedImage a partir de la imagen contenido en icon
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();

            // Guardamos la imagen en el archivo imgFile
            try {
                ImageIO.write(image, "jpg", imgFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo");
            }
        }
    }//GEN-LAST:event_menuItemGuardarComoActionPerformed

    // Este método pinta con el pincel
    private void btnPintarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPintarActionPerformed
        if (evt.getSource() == btnPintar) {
            // Elimina el mouse listener anterior, en caso de que haya uno.
            // Esto es para evitar problemas entre herramientas
            if (currentMouseListener != null) {
                labelImage.removeMouseListener(currentMouseListener);
                labelImage.removeMouseMotionListener(currentMouseListener);
            }

            // Se inicializa el mouse listener del pincel
            // currentMouseListener es la variable de la clase
            currentMouseListener = new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    // Guarda la posición del mouse al presionarlo
                    prevPoint = e.getPoint();
                }

                public void mouseDragged(MouseEvent e) {
                    // Dibuja una línea entre la posición actual del mouse y la posición anterior                    
                    Graphics2D g2 = (Graphics2D) labelImage.getGraphics();
                    g2.setStroke(new BasicStroke(5)); // establece el ancho de la línea a 5
                    g2.setColor(Color.RED); // establece el color de la línea a rojo
                    g2.drawLine(prevPoint.x, prevPoint.y, e.getX(), e.getY());
                    prevPoint = e.getPoint(); // actualiza la posición anterior del mouse
                }
            };

            // Se le añade el mouse listener al label
            labelImage.addMouseListener(currentMouseListener);
            labelImage.addMouseMotionListener(currentMouseListener);
        }
    }//GEN-LAST:event_btnPintarActionPerformed

    // Este método dibuja líneas rectas
    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        if (evt.getSource() == btnLinea) {
            // Elimina el mouse listener anterior, en caso de que haya uno.
            if (currentMouseListener != null) {
                labelImage.removeMouseListener(currentMouseListener);
                labelImage.removeMouseMotionListener(currentMouseListener);
            }

            // Declara las coordenadas para el primer punto de la línea.
            Graphics2D g2d = (Graphics2D) labelImage.getGraphics();
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(Color.GREEN);

            // Declara el mouse listener de la línea.
            currentMouseListener = new MouseAdapter() {
                @Override
                // cuando el mouse se presiona
                public void mousePressed(MouseEvent e) {
                    // inicializa las coordenadas del primer punto de la línea.
                    x1 = e.getX();
                    y1 = e.getY();
                }

                @Override
                // Cuando se suelta el botón del mouse
                public void mouseReleased(MouseEvent e) {
                    // cuando se suelta el mouse, se toman las coordenadas del otro punto para que este sea el final de la línea.
                    int x2 = e.getX();
                    int y2 = e.getY();
                    // se dibuja la línea.
                    g2d.drawLine(x1, y1, x2, y2);
                }
            };
            // su respectivo mouse listener :)
            labelImage.addMouseListener(currentMouseListener);
        }
    }//GEN-LAST:event_btnLineaActionPerformed

    // Este método es para crear un lienzo en blanco, con las medidas originales, aunque ya se haya puesto una imagen
    private void menuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevoActionPerformed
        // Restablecemos las medidas del label
        labelImage.setSize(1200, 720);
        
        // El ícono del lienzo en blanco
        ImageIcon icon = new ImageIcon(getClass().getResource("/iconos/white_cover.jpg"));
        
        // Objeto Image para manipular el icono y hacerlo a las medidas del label
        Image img = icon.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);

        // Establecemos el lienzo en blanco como el ícono del label
        labelImage.setIcon(new ImageIcon(img));

        // currentImage pasa a ser la imagen del lienzo
        // Esto es para también poder escalarlo si se quiere
        currentImage = (ImageIcon) labelImage.getIcon();
    }//GEN-LAST:event_menuItemNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorImagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscalar;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnPintar;
    private javax.swing.JLabel labelImage;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemAbrir;
    private javax.swing.JMenuItem menuItemGuardar;
    private javax.swing.JMenuItem menuItemGuardarComo;
    private javax.swing.JMenuItem menuItemNuevo;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JPanel panelHerramientas;
    // End of variables declaration//GEN-END:variables
}
