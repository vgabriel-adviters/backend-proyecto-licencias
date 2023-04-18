package com.adviters.administracionusuarios.config;

import com.adviters.administracionusuarios.models.entities.FeriadoEntity;
import com.adviters.administracionusuarios.models.entities.LicenciaEstadoEntity;
import com.adviters.administracionusuarios.repositories.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitialDataFeriados {

    @Autowired
    private FeriadoRepository feriadoRepository;

    @PostConstruct
    public void loadInitialData() {
        if (feriadoRepository.count() == 0) {
            FeriadoEntity feriado1 = new FeriadoEntity();
            feriado1.setId(1L);
            feriado1.setFecha("01-01-2023");
            feriado1.setMotivo("Año Nuevo");

            FeriadoEntity feriado2 = new FeriadoEntity();
            feriado2.setId(2L);
            feriado2.setFecha("20-02-2023");
            feriado2.setMotivo("Carnaval");

            FeriadoEntity feriado3 = new FeriadoEntity();
            feriado3.setId(3L);
            feriado3.setFecha("21-02-2023");
            feriado3.setMotivo("Carnaval");

            FeriadoEntity feriado4 = new FeriadoEntity();
            feriado4.setId(4L);
            feriado4.setFecha("24-03-23");
            feriado4.setMotivo("Día Nacional de la Memoria por la Verdad y la Justicia");

            FeriadoEntity feriado5 = new FeriadoEntity();
            feriado5.setId(5L);
            feriado5.setFecha("02-04-2023");
            feriado5.setMotivo("Día del Veterano y de los Caídos en la Guerra de Malvinas");

            FeriadoEntity feriado6 = new FeriadoEntity();
            feriado6.setId(6L);
            feriado6.setFecha("07-04-2023");
            feriado6.setMotivo("Viernes Santo Festividad Cristiana");

            FeriadoEntity feriado7 = new FeriadoEntity();
            feriado7.setId(7L);
            feriado7.setFecha("01-05-2023");
            feriado7.setMotivo("Día del Trabajador");

            FeriadoEntity feriado8 = new FeriadoEntity();
            feriado8.setId(8L);
            feriado8.setFecha("25-05-2023");
            feriado8.setMotivo("Día de la Revolución de Mayo");

            FeriadoEntity feriado9 = new FeriadoEntity();
            feriado9.setId(9L);
            feriado9.setFecha("26-05-2023");
            feriado9.setMotivo("Feriado Puente Turístico");

            FeriadoEntity feriado10 = new FeriadoEntity();
            feriado10.setId(10L);
            feriado10.setFecha("17-06-2023");
            feriado10.setMotivo("Paso a la Inmortalidad del Gral. Don Martín Güemes");

            FeriadoEntity feriado11 = new FeriadoEntity();
            feriado11.setId(11L);
            feriado11.setFecha("19-06-2023");
            feriado11.setMotivo("Feriado Puente Turístico");

            FeriadoEntity feriado12 = new FeriadoEntity();
            feriado12.setId(12L);
            feriado12.setFecha("20-06-2023");
            feriado12.setMotivo("Paso a la Inmortalidad del General Manuel Belgrano");

            FeriadoEntity feriado13 = new FeriadoEntity();
            feriado13.setId(13L);
            feriado13.setFecha("09-07-2023");
            feriado13.setMotivo("Día de la Independencia");

            FeriadoEntity feriado14 = new FeriadoEntity();
            feriado14.setId(14L);
            feriado14.setFecha("21-08-2023");
            feriado14.setMotivo("Paso a la Inmortalidad del General José de San Martín");

            FeriadoEntity feriado15 = new FeriadoEntity();
            feriado15.setId(15L);
            feriado15.setFecha("13-10-2023");
            feriado15.setMotivo("Feriado Puente Turístico");

            FeriadoEntity feriado16 = new FeriadoEntity();
            feriado16.setId(16L);
            feriado16.setFecha("16-10-2023");
            feriado16.setMotivo("Día del Respeto a la Diversidad Cultural");

            FeriadoEntity feriado17 = new FeriadoEntity();
            feriado17.setId(17L);
            feriado17.setFecha("20-11-2023");
            feriado17.setMotivo("Día de la Soberanía Nacional");

            FeriadoEntity feriado18 = new FeriadoEntity();
            feriado18.setId(18L);
            feriado18.setFecha("08-12-2023");
            feriado18.setMotivo("Inmaculada Concepción de María");


            FeriadoEntity feriado19 = new FeriadoEntity();
            feriado19.setId(19L);
            feriado19.setFecha("25-12-2023");
            feriado19.setMotivo("Navidad");

            feriadoRepository.saveAll(Arrays.asList(
                    feriado1,
                    feriado2,
                    feriado3,
                    feriado4,
                    feriado5,
                    feriado6,
                    feriado7,
                    feriado8,
                    feriado9,
                    feriado10,
                    feriado11,
                    feriado12,
                    feriado13,
                    feriado14,
                    feriado15,
                    feriado16,
                    feriado17,
                    feriado18,
                    feriado19
            ));
        }
    }
}