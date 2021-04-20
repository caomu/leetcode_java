package com.caomu.util;

import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/02/10, 水, 18:06
 */
public class Utils {
    private static final Logger logger = Logger.getLogger(Utils.class.toString());

    public static TreeNode arrayToTreeNode(String s) {
        List<Integer> array = Arrays.stream(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")).split(",")).map(i ->
                i.equals("null") ? null : Integer.valueOf(i)
        ).collect(Collectors.toList());
        return list2TreeNode(array);
    }

    public static TreeNode list2TreeNode(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.size(); i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array.get(i) != null) {
                    assert node != null;
                    node.left = new TreeNode(array.get(i));
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array.get(i) != null) {
                    assert node != null;
                    node.right = new TreeNode(array.get(i));
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static int[] stringToArray(String s) {
        return Arrays.stream(s.substring(
                s.indexOf("[") + 1, s.lastIndexOf("]")).split(",")).mapToInt(Integer::valueOf).toArray();
    }

    public static String[] stringToStringArray(String s) {
        return ((JSONArray) JSONArray.parse(s)).toArray(new String[]{});
    }

    public static int[][] stringTo2DArray(String s) {
        JSONArray[] arr = ((JSONArray) JSONArray.parse(s)).toArray(new JSONArray[]{});
        int[][] result = new int[arr.length][Arrays.stream(arr).mapToInt(JSONArray::size).max().orElse(0)];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Arrays.stream(arr[i].toArray()).mapToInt(o -> (int) o).toArray();
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }

    public static List<List<String>> stringTo2DStringList(String s) {
        JSONArray[] arr = ((JSONArray) JSONArray.parse(s)).toArray(new JSONArray[]{});
        List<List<String>> result = new ArrayList<>();
        for (JSONArray objects : arr) {
            List<String> list = Arrays.stream(objects.toArray()).map(String::valueOf).collect(Collectors.toList());
            result.add(list);
            System.out.println(list);
        }
        return result;
    }

    public static void reflectCallingFunction(Object obj, String methods, String params) {
        reflectCallingFunction(obj, stringToStringArray(methods), stringTo2DArray(params));
    }

    public static void reflectCallingFunction(Object obj, String[] methods, int[][] params) {
        Class clazz = obj.getClass();
        for (int i = 0; i < methods.length; i++) {
            Method method;
            Object result = null;
            try {
                if (params[i].length == 0) {
                    method = clazz.getDeclaredMethod(methods[i]);
                    method.setAccessible(true);
                    result = method.invoke(obj);
                } else if (params[i].length == 1) {
                    method = clazz.getDeclaredMethod(methods[i], int.class);
                    method.setAccessible(true);
                    result = method.invoke(obj, params[i][0]);
                } else if (params[i].length == 2) {
                    method = clazz.getDeclaredMethod(methods[i], int.class, int.class);
                    method.setAccessible(true);
                    result = method.invoke(obj, params[i][0], params[i][1]);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            logger.log(Level.WARNING, "method:{0}\tparams:{1}\tresult:{2}", new Object[]{methods[i], Arrays.toString(params[i]), result});

        }
    }
}
