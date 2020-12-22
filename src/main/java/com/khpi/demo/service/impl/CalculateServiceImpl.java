package com.khpi.demo.service.impl;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.dto.CalculationDTO;
import com.khpi.demo.entity.HashCode;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.entity.enumeration.CutType;
import com.khpi.demo.service.CalculateService;
import com.khpi.demo.service.algorithm.Algorithm;
import com.khpi.demo.service.algorithm.AlgorithmContainer;
import com.khpi.demo.service.generator.GeneratorContainer;
import com.khpi.demo.service.generator.MackAddressGenerator;
import com.khpi.demo.util.filler.ByteFiller;
import com.khpi.demo.util.filler.impl.FourBytesFiller;
import com.khpi.demo.util.filler.impl.TwoBytesFiller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private GeneratorContainer generatorContainer;

    private AlgorithmContainer algorithmContainer;

    @Override
    public CalculationDTO calculate(CalculateDTO calculateDTO) {
        MackAddressGenerator generator = generatorContainer.get(calculateDTO.getDataGeneration());
        Set<MackAddress> mackAddresses = generator.generate(calculateDTO);

        //outMackAddress(mackAddresses);
        ByteFiller byteFiller;
        if (CutType.CUT16.equals(calculateDTO.getCut())) {
            byteFiller = new TwoBytesFiller();
        } else {
            byteFiller = new FourBytesFiller();
        }


        Algorithm algorithm = algorithmContainer.get(calculateDTO.getAlgorithm());
        Set<HashCode> resultSet = new LinkedHashSet<>();
        long executionTimeMilliseconds = calculateExecutionTime(algorithm, mackAddresses, resultSet, byteFiller);

        //outMackHashes(resultSet);

        CalculationDTO calculationDTO = new CalculationDTO();
        calculationDTO.setAlgorithm(calculateDTO.getAlgorithm().name());
        calculationDTO.setNumberElements(calculateDTO.getNumberElements());
        calculationDTO.setExecutionTime(executionTimeMilliseconds);
        calculationDTO.setNumberOfCollisions(calculateDTO.getNumberElements() - resultSet.size());
        calculationDTO.setBits(calculateDTO.getCut().getBits());
        return calculationDTO;
    }

    private void outMackAddress(Set<MackAddress> mackAddresses) {
        try (FileWriter writer = new FileWriter("mac", true)) {
            for (MackAddress mackAddress : mackAddresses) {
                writer.write(mackAddress.toString() + " ");
            }
            writer.append("\n");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private void outMackHashes(Set<HashCode> resultSet) {
        try (FileWriter writer = new FileWriter("mac", true)) {
            for (HashCode hash : resultSet) {
                writer.write(hash.toString() + " ");
            }
            writer.append("\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private long calculateExecutionTime(Algorithm algorithm,
                                        Set<MackAddress> mackAddresses,
                                        Set<HashCode> resultSet,
                                        ByteFiller byteFiller) {
        long then;
        long executionTime;
        List<HashCode> hashCodes;
        synchronized (this) {
            then = System.nanoTime();
            hashCodes = algorithm.execute(mackAddresses, byteFiller);
            executionTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then);
        }
        resultSet.addAll(hashCodes);
        return executionTime;
    }
}
