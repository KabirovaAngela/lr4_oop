import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HarmonicMotionApp extends JFrame {
    private double q; // Длина отрезка
    private double w; // Константа w
    private boolean running; // Флаг для отслеживания состояния процесса

    public HarmonicMotionApp() {
        setTitle("Гармонические колебания");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Создание полей ввода
        JTextField qField = new JTextField(10);
        JTextField wField = new JTextField(10);

        // Создание кнопок
        JButton startButton = new JButton("Старт");
        JButton stopButton = new JButton("Стоп");

        // Установка действий для кнопок
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получение введенных значений
                q = Double.parseDouble(qField.getText());
                w = Double.parseDouble(wField.getText());
                running = true;
                calculateMotion(); // Запуск процесса гармонических колебаний
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false; // Остановка процесса гармонических колебаний
            }
        });

        // Создание панели и добавление компонентов
        JPanel panel = new JPanel();
        panel.add(new JLabel("Длина отрезка (q):"));
        panel.add(qField);
        panel.add(new JLabel("Константа (w):"));
        panel.add(wField);
        panel.add(startButton);
        panel.add(stopButton);
        add(panel);

        setVisible(true);
    }

    private void calculateMotion() {
        while (running) {
            // Вычисление расстояния от точки до левого конца в момент времени t
            double t = System.currentTimeMillis() / 1000.0; // Текущее время в секундах
            double distance = q * (1 + Math.cos(w * t)) / 2;

            System.out.println("Расстояние: " + distance);
        }
    }

    public static void main(String[] args) {
        new HarmonicMotionApp();
    }
}