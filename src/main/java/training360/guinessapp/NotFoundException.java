package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {

    public NotFoundException(Long id) {
        super(URI.create("record/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("%d id is not found", id));
    }
}
