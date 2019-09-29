int minXOR = Integer.MAX_VALUE;
		Arrays.parallelSort(a);
		for (int i = 0; i < a.length-1; i++) 
		{
			// System.out.println("a[j] pair: " + a[i] + " a[j] pair: " + a[j+1]);
			minXOR = Math.min(minXOR, a[i] ^ a[i+1]);

		}

		return minXOR;
