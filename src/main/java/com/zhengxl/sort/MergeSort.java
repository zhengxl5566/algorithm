package com.zhengxl.sort;

/**
 * @description: 归并排序
 * @projectName:algorithm
 * @see:com.zhengxl.sort
 * @author:郑晓龙
 * @createTime:2020/9/9 15:49
 * @version:1.0
 */
public class MergeSort implements Sort {
    @Override
    public void sortDesc(int[] array) {
        if (array == null) {
            return;
        }
        int size = array.length;
        if (size <= 1) {
            return;
        }

        mergeSort(array, 0, size - 1);
    }

    private void mergeSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;

        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);

        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }

    }
}
