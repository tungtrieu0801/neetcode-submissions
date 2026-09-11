class Solution {
    public boolean isValid(String s) {
        List<Character> listOpen = new ArrayList<>();

        listOpen.addAll(0, List.of('(', '[', '{'));

        List<Character> listClose = new ArrayList<>();

        listClose.addAll(0, List.of(')', ']', '}'));

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.toCharArray()[i]);
            if (listOpen.contains(s.toCharArray()[i])) {
                stack.add(s.toCharArray()[i]);
            } else {
                if(stack.isEmpty()) return false;
                if (s.toCharArray()[i] == ')') {
                    if (stack.getLast() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

                if (s.toCharArray()[i] == '}') {
                    if (stack.getLast() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

                if (s.toCharArray()[i] == ']') {
                    if (stack.getLast() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.size() == 0) return true;

        return false;

    }
}