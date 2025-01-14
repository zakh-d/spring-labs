import { ReactElement, useState } from "react";
import {
    Button,
    Header,
    Icon,
    Modal,
    ModalActions,
    ModalContent,
} from "semantic-ui-react";


type PropsType = {
    trigger: ReactElement,
    title: string,
    content: string | ReactElement,
    action: () => void
}

const ConfirmDeleteModal = ({trigger, title, content, action}: PropsType): ReactElement => {
    const [open, setOpen] = useState(false);

    return (
        <Modal
            basic
            onClose={() => setOpen(false)}
            onOpen={() => setOpen(true)}
            open={open}
            size="small"
            trigger={trigger}>
            <Header icon>
                <Icon name="trash alternate" />
                {title}
            </Header>
            <ModalContent>
                <p>
                    {content}
                </p>
            </ModalContent>
            <ModalActions>
                <Button basic inverted onClick={() => setOpen(false)}>
                    <Icon name="remove" /> No
                </Button>
                <Button color="red" inverted onClick={() => {
                    setOpen(false);
                    action();
                }}>
                    <Icon name="checkmark" /> Yes
                </Button>
            </ModalActions>
        </Modal>
    );
};

export default ConfirmDeleteModal;