import { ReactElement, ReactNode } from "react"
import {Header, Modal, ModalContent } from "semantic-ui-react"

type PropsType = {
    title: string,
    children: ReactElement,
    trigger: ReactNode
    isOpen: boolean,
    setOpen: (value: boolean) => void
}

const BasicModal = ({isOpen, setOpen, title, trigger, children}: PropsType): ReactElement => {
    return <Modal
            closeIcon
            onClose={() => setOpen(false)}
            onOpen={() => setOpen(true)}
            open={isOpen}
            trigger={trigger}
            size="small">
            <Header icon>
                {title}
            </Header>
            <ModalContent>
                {children}
            </ModalContent>
        </Modal>
}

export default BasicModal;