package it.mauluk92.dictionary.a.util.zip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.*;

public class Adler32Test {

    /**
     * The {@link Adler32} class implements the ADLER-32 algorithm that is used
     * to produce a checksum value on a stream of data. The ADLER-32 algorithm
     * is described in <strong>RFC 1950</strong>. The java.util.zip package
     * provides implementations of two different checksum algorithms:
     * ADLER-32 and CRC-32. The ADLER-32 is faster while CRC-32 produces
     * better quality checksum values.
     */
    @Test
    @DisplayName("Description")
    public void description(){
        Adler32 adler32 = new Adler32();
        Assertions.assertInstanceOf(Adler32.class, adler32);
    }

    /**
     * To use this class to compute the checksum of a data set, you first
     * create an instance of this class. You then must call the new object's
     * update() with the bytes of the data set. It is important to be consistent with
     * the order of the bytes supplied to update(). Supplying bytes in different order
     * will produce a different checksum. After this, you call getValue() to retrieve
     * the checksum value. To compute the checksum of another data set, you can either
     * create a new {@link Adler32} object or simply call the current object's reset()
     * method. This class is used in conjunction with the {@link CheckedInputStream} and
     * {@link CheckedOutputStream} classes, which make it convenient to compute the
     * checksum on streaming data.
     */
    @Test
    @DisplayName("Usage")
    public void usage() throws IOException {
        Adler32 checksum = new Adler32();
        Resource rootDirectoryResource = new ClassPathResource("dictionary/a/adler32");
        try(Stream<Path> files = Files.walk(rootDirectoryResource.getFile().toPath(), 3)){
            Set<Path> regularFiles = files.filter(Files::isRegularFile).collect(Collectors.toSet());
            for(Path p : regularFiles){
                checksum.reset();
                checksum.update(Files.readAllBytes(p));
                System.out.printf("File %s has checksum %s%n", p.getFileName(), checksum.getValue());
            }
        }
    }
}
