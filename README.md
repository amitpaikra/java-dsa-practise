# java-dsa-practise
	try {
		Scanner sc = new Scanner(new File ("testcases/1.txt"));
		int numberOfTestCase = sc.nextInt();
		while (numberOfTestCase-- > 0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] array = new int[N];
			System.out.println("N="+N+", K"+K);
			for (int i = 0; i < N; ++i) {
				array[i] = sc.nextInt();
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	} catch (FileNotFoundException e) {
		System.err.println("File Not exist : " + e);	
	}
