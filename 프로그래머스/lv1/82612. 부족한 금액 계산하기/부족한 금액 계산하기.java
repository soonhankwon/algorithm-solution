import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

class Solution {
    public long solution(int price, int money, int count) {
        AtomicLong charge = new AtomicLong();
        IntStream.rangeClosed(1, count)
                .forEach(i -> charge.addAndGet((long) i * price));

        return money >= charge.get() ? 0 : Math.abs(money - charge.get());
    }
}