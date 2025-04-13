
import java.util.Arrays;

/**************************************
    
    Following is the point class
    
    class point {
		int x;
		int y;
	
		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	 }
  
 **************************************/

 class point {
	int x;
	int y;

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}
 }
public class Solution {
	
	private static long getDistance(point a, point b) {
		return ( ((long)a.x-b.x)*((long)a.x-b.x) + ((long)a.y-b.y)*((long)a.y-b.y) );
	}

	private static long bruteForce (point coordinates[], int n) {
		
		long distance = getDistance(coordinates[0], coordinates[1]);

		for (int i = 1; i < n; ++i) {
			for (int j = i+1; j < n; ++j) {
				distance = Math.min(distance, getDistance(coordinates[i], coordinates[j]));
			}
		}
		
		return distance;
	}


	private static long cpMid(point[] points, int length, long distance) {
		
		for (int i = 0; i < length; ++i ) {
			for (int j = i+1; j < length; ++j) {
				if (Math.abs(points[i].y-points[i].y) < distance) {
					distance = Math.min(distance, getDistance(points[i], points[j]) );
				}
			}
		}		
		return distance;
	}

	private static void pf(String message) {
		System.out.println(message);
	}

	private static long cp (point[] sortedX, point[] sortedY) {


		int length = sortedX.length;
		if (length <= 3) {
			return bruteForce (sortedY, length);
		}

		int mid = length/2;
		point midPoint = sortedX[mid];

		point[] leftRegionSortedX = new point[mid];
		point[] leftRegionSortedY = new point[mid];

		// System.out.println("MID:"+mid +", REST:"+(length-mid));
		point[] rightRegionSortedX = new point[length-mid];
		point[] rightRegionSortedY = new point[length-mid];

		int LRSY=0, RRSY=0;
		//pf ("sortedY:"+sortedY.length+", lRSY:"+leftRegionSortedY.length+"rrsy:"+rightRegionSortedY.length );
		for (int i = 0; i < sortedY.length; ++i) {
			pf ("LRSY: " + LRSY + ", mid: " + mid + ", RRSY: " + RRSY );
			if ( LRSY < mid && sortedY[i].x <= midPoint.x ) {
				leftRegionSortedY[LRSY++] = sortedY[i];
			}
			else {
				// if (RRSY >= rightRegionSortedY.length ) {
				// 	pf("Cause RRSY point fault");
				// 	// return 2;
				// }
				rightRegionSortedY[RRSY++] = sortedY[i];
			}
		}

		int LRSX = 0, RRSX=0;
		for (int i = 0; i < sortedX.length; ++i) {
			if ( i < leftRegionSortedX.length ) {
				leftRegionSortedX[LRSX++] = sortedX[i]; 
			}
			else {
				// if ( i >= rightRegionSortedX.length) {
				// 	System.out.println("i==>"+i+", rrsx = " + rightRegionSortedX.length + ", mid=" + mid + ", lrsx="+leftRegionSortedX.length) ;
				// 	System.out.println("SortedX="+sortedX.length);
				// 	return 2L;
				// }
				rightRegionSortedX[RRSX++] = sortedX[i];
			}
		}

		long dL = cp (leftRegionSortedX, leftRegionSortedY);
		long dR = cp (rightRegionSortedX, rightRegionSortedY);

		long d = Math.min (dL, dR);
		point midRegion[] = new point[sortedY.length];
		int midRegionIdx = 0;
		for (int i = 0; i < sortedY.length; i++) {
			if ((long)Math.abs(sortedY[i].x - midPoint.x) < d) {
				midRegion[midRegionIdx++] = sortedY[i];
			}
		}

		return cpMid(midRegion, midRegionIdx, d);				
	}

	public static long closestPair(point coordinates[], int n) {

		point[] cX = new point[n];	
		point[] cY = new point[n];

		for (int i = 0; i < n; ++i) {
			cX[i] = coordinates[i];
			cY[i] = coordinates[i];
		}	

		Arrays.sort(cX, (a, b) -> Integer.compare(a.x, b.x));
		Arrays.sort(cY, (a, b) -> Integer.compare(a.y, b.y));

		return cp (cX, cY);
	}
	
}
