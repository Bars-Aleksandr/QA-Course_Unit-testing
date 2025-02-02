package seminars.second;

import org.junit.jupiter.api.*;
import seminars.second.hw.Car;
import seminars.second.hw.Motorcycle;
import seminars.second.hw.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Домашнее задание к семинару №2 JUnit:
 */
public class VehicleTest {
    /**
     * @param car - класс имитирующий работу автомобиля
     * @param motorcycle - класс имитирующий работу мотоцикла
     */

    private Car car;
    private Motorcycle motorcycle;

    /**
     * метод выполняющий подготовку для тестов:
     * создаются экземпляры car и motorcycle
     */
    @BeforeEach
    void setup() {
        car = new Car("bmw", "M5", 2000);
        motorcycle = new Motorcycle("Honda", "S2000", 2010);
    }

    /**
     * проверка того, что экземпляр объекта Car также является экземпляром транспортного средства;
     */
    @Test
    void testCarIsInstanceOfVehicle() {

        assertThat(car instanceof Vehicle);
    }

    /**
     * проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    void carSpeedTestDriveIs60() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    void motorcycleSpeedTestDriveIs75() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * проверка, что в режиме парковки машина останавливается (speed = 0)
     */
    @Test
    void carSpeedParkDriveIs0() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * проверить, что в режиме парковки мотоцикл останавливается (speed = 0)
     */
    @Test
    void motorcycleSpeedParkDriveIs0() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
