# PracticaCalificada4

## Pregunta 1
<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/p1-1.png" alt="Logo SOS">
</h1>

Pre-condiciones:
- El arreglo debe ser no nula y de longitud > 0

En el siguiente codigo se muestra la implimentacion de las pre-condiciones y el contar clumps:
- En la primera condicional ¨if¨ se evalua si el arreglo es nula y si la longitud es 0, donde si cumple alguna de estas codiciones
retorna 0 en caso contrario cuenta clumps.

```
int count = 0, temp, val = 0;
if(nums == null || nums.length == 0 ){
    return 0;
}
for (int i = 0; i < nums.length-1; i++) {
    temp = nums[i+1];
    if (nums[i] == temp && val == 0){
        count++;
        val ++;
    }
    if (nums[i] != temp) {
        val = 0;
    }
}
return count;
```

<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/p1-2.png" alt="Logo SOS">
</h1>

Si se quiere cubrir el 100% de cobertura entonces algunos casos que se estarian analizan serian los siguientes casos:
- 1 grupo de 1 elemento
- 1 grupo de 2 elementos
- 1 grupo de más de 2 elementos
- 2 grupos que se repiten con longitudes iguales
- 2 grupos que se repiten con longitudes diferentes
EL arreglo que cumple con estas condiciones es:
```
[1, 2, 2, 1, 1, 3, 3, 3, 5, 2, 2, 2, 3, 3, 3]
```
El siguiente codigo se hace la implementacion y para el arreglo dado se muestra el valor de: 5
```
public class Clumps {

    public static void main(String[] args) {
        int [] nums = new int[]{1, 2, 2, 1, 1, 3, 3, 3, 5, 2, 2, 2, 3, 3, 3};
        System.out.println(countClumps(nums));
    }

    public static int countClumps(int []nums){
        int count = 0, temp, val = 0;
        if(nums == null || nums.length ==0 ){
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            temp = nums[i+1];
            if (nums[i] == temp && val == 0){
                count++;
                val ++;
            }
            if (nums[i] != temp) {
                val = 0;
            }
        }
        return count;
    }
}

```
<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/p2.png" alt="Logo SOS">
</h1>

- T1: un arreglo vacio
- T2: un arreglo nulo
- T3: un arreglo con un solo grupo ([1,2,2,1])
- T4: un arreglo de un solo elemento

<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/p1-3.png" alt="Logo SOS">
</h1>

```
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class ClumpsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void testClumps(int[] nums, int expectedNoOfClumps) {
        assertThat(Clumps.countClumps(nums))
                .isEqualTo(expectedNoOfClumps);
    }


    static Stream<Arguments> generator() {
        return Stream.of(
                of(new int[]{}, 0), //T1
                of(null, 0), //T2
                of(new int[]{1,2,2,1}, 1), //T3
                of(new int[]{1}, 0) //T4
        );
    }
}
```
<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/solp4.png" alt="Logo SOS">
</h1>
<h1 align="center">
  <img src="https://raw.githubusercontent.com/owamns/PracticaCalificada4/main/files/p4.png" alt="Logo SOS">
</h1>

De la clase Clumps.java se observa las siguientes ramas:
- La rama dentro del primer "if" se activa cuando nums == null o nums.length == 0.
- La rama dentro del primer bucle "for" se activa cuando i < nums.length - 1.
- La rama dentro del segundo "if" se activa cuando nums[i] == temp && val == 0.
- La rama dentro del segundo "if" se activa cuando nums[i] != temp.
```
Un arreglo vacío: nums = new int []{}. Esto cubre la rama del primer "if" que devuelve 0 sin ejecutar el bucle.
```
```
Un arreglo con un solo elemento: nums = [1]. Esto cubre la rama del primer "if" que devuelve 0 sin ejecutar el bucle.
```
```
Un arreglo con dos elementos iguales: nums = [2, 2]. Esto cubre todas las ramas del código.
```
```
Un arreglo con varios clumps: nums = [1, 2, 2, 3, 3, 3, 4]. Esto cubre todas las ramas del código.
```
De esto se puede ver que código cobertura de ramas no abarca los casos del enunciado "Experimenta con el último
clump en el último elemento del arreglo o con un conjunto que tiene un clump que comienza en la primera
posición".
