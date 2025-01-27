import { ReactElement } from "react";
import { Placeholder } from "semantic-ui-react";

const WorkoutPlaceholder = (): ReactElement => {
    return (
        <Placeholder>
            <Placeholder.Header>
                <Placeholder.Line />
            </Placeholder.Header>
            <Placeholder.Paragraph>
                <Placeholder.Line />
                <Placeholder.Line />
                <Placeholder.Line />
            </Placeholder.Paragraph>
        </Placeholder>
    );
}

export default WorkoutPlaceholder;