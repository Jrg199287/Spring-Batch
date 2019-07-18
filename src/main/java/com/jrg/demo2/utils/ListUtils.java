package com.jrg.demo2.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	/**
	 * 
	 * @methodDesc: ????????:(list ????????и?)
	 * @author: ?????
	 * @param: @param
	 *             list
	 * @param: @param
	 *             pageSize
	 * @param: @return
	 * @createTime:2017??8??7?? ????9:30:59
	 * @returnType:@param list ?и???
	 * @returnType:@param pageSize ???????
	 * @returnType:@return List<List<T>> ??????????
	 * @copyright:??????????????????
	 */

	static public <T> List<List<T>> splitList(List<T> list, int pageSize) {
		int listSize = list.size();
		int page = (listSize + (pageSize - 1)) / pageSize;
		List<List<T>> listArray = new ArrayList<List<T>>();
		for (int i = 0; i < page; i++) {
			List<T> subList = new ArrayList<T>();
			for (int j = 0; j < listSize; j++) {
				int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
				if (pageIndex == (i + 1)) {
					subList.add(list.get(j));
				}
				if ((j + 1) == ((j + 1) * pageSize)) {
					break;
				}
			}
			listArray.add(subList);
		}
		return listArray;
	}
}
