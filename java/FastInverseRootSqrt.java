import java.lang.Float;
public class FastInverseRootSqrt {
	public static void main(String args[]) {
		float a = 3278984;	
		System.out.println("a = " + a + " , sqrt(a) = " + 1 / invsqrt(a));

	}

	public static float invsqrt(float a) {
		float half = a * 0.5f;
		int i = Float.floatToIntBits(a);
		//i = 0x5f3759df - (i >> 1);
		i = 0x5f375a86 - (i >> 1);
		a = Float.intBitsToFloat(i);
		for(int j = 0; j < 2; j++) {
			a *= (1.5f - half * a * a);
			System.out.println((1 / a) * (1 / a));
		}
		return a;
	}

	
}
