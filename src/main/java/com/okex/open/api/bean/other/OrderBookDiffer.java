package com.okex.open.api.bean.other;

import java.util.*;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:45:17
 *
 */
public class OrderBookDiffer {

	/**
	 * 
	 * 添加参数 order: 1正向排序 2反向排序
	 * 
	 * @param <T>
	 * @param current
	 * @param snapshot
	 * @param comparator
	 * @param order
	 * @return
	 */
	public <T extends OrderBookItem<?>> List<T> diff(List<T> current, List<T> snapshot,
			final Comparator<String> comparator, int order) {

		// 增量的数组
		final Iterator<T> snapshotIter = snapshot.iterator();
		// 现有全量的数据
		final Iterator<T> currentIter = current.iterator();
		final List<T> diff = new ArrayList<>(current.size());
		if (snapshotIter.hasNext() && currentIter.hasNext()) {
			T snapshotBookItem = snapshotIter.next();
			T currentBookItem = currentIter.next();

			for (;;) {
				double currentPrc = Double.parseDouble(currentBookItem.getPrice());
				double snapPrc = Double.parseDouble(snapshotBookItem.getPrice());
				int compare = 0;
				// 增>全
				boolean bigger = (order == 1 && snapPrc > currentPrc) || (order == 2 && snapPrc < currentPrc);
				// 增<全
				boolean less = (order == 1 && snapPrc < currentPrc) || (order == 2 && snapPrc > currentPrc);
				if (bigger) {
					compare = 1;
				} else if (less) {
					compare = -1;
				}

				// 价格相等时候
				if (compare == 0) {

					if (!"0".equals(snapshotBookItem.getSize().toString())) {
						diff.add(snapshotBookItem);
					}

					if (currentIter.hasNext() && snapshotIter.hasNext()) {
						currentBookItem = currentIter.next();
						snapshotBookItem = snapshotIter.next();
					} else {
						break;
					}
					// 增量价格小于全量的
				} else if (compare < 0) {
					if (!"0".equals(snapshotBookItem.getSize().toString())) {
						diff.add(snapshotBookItem);
					}
					if (snapshotIter.hasNext()) {
						snapshotBookItem = snapshotIter.next();
					} else {
						diff.add(currentBookItem);
						break;
					}
				} else {
					diff.add(currentBookItem);
					if (currentIter.hasNext()) {
						currentBookItem = currentIter.next();
					} else {
						if (!"0".equals(snapshotBookItem.getSize().toString())) {
							diff.add(snapshotBookItem);
						}
						break;
					}
				}
			}
		}

		if (!snapshotIter.hasNext()) {
			currentIter.forEachRemaining(diff::add);
		}
		if (!currentIter.hasNext()) {
			snapshotIter.forEachRemaining(diff::add);
		}
		// 返回不可修改的diff
		return Collections.unmodifiableList(diff);

	}
}
