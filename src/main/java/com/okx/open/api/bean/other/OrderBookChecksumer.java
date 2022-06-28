package com.okx.open.api.bean.other;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:45:08
 *
 */
public class OrderBookChecksumer {

	private final HashFunction crc32 = Hashing.crc32();

	public <T extends OrderBookItem<?>> int checksum(List<T> asks, List<T> bids) {
		StringBuilder s = new StringBuilder();
		int num = 25;
		for (int i = 0; i < num; i++) {
			if (i < bids.size()) {
				s.append(bids.get(i).getPrice().toString());
				s.append(":");
				s.append(bids.get(i).getSize());
				s.append(":");
			}
			if (i < asks.size()) {
				s.append(asks.get(i).getPrice().toString());
				s.append(":");
				s.append(asks.get(i).getSize());
				s.append(":");
			}
		}
		final String str;
		if (s.length() > 0) {
			str = s.substring(0, s.length() - 1);
		} else {
			str = "";
		}

		return crc32.hashString(str, StandardCharsets.UTF_8).asInt();
	}
}
