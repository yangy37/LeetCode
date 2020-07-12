class Solution {
    public String maskPII(String S) {
        if (S.indexOf("@") != -1) {
            S=S.toLowerCase();
			String[] split = S.split("@");
			String left = split[0];
			return left.charAt(0) + "*****" + left.charAt(left.length() - 1) + "@" + split[1];
		} else {
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = S.length() - 1; i >= 0; i--) {
				char c = S.charAt(i);
				if (c >= '0' && c <= '9') {
					if (cnt < 4) {
						sb.insert(0, c);
					}
					cnt++;
				}
			}
			if (cnt == 10) {
				return "***-***-" + sb.toString();
			} else {
				StringBuilder prefix = new StringBuilder();
				int remain = cnt - 10;
				while (remain > 0) {
					prefix.append("*");
					remain--;
				}
				return "+" + prefix.toString() + "-" + "***-***-" + sb.toString();
			}
		}

    }
}