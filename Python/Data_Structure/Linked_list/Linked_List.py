class Node(object):
    def __init__(self,key=None):
        self.prev=None
        self.next=None
        self.key=key

class DoubleLinkedList(object):
    def __init__(self):
        head=Node()
        tail=Node()
        self.head=head
        self.tail=tail
        self.head.next=self.tail
        self.tail.prev=self.head
        
    def append(self,key):
        node=Node(key)
        prev=self.tail.prev
        prev.next=node
        node.prev=prev
        self.tail.prev=node
        node.next=self.tail
        return node
    
    def get(self,index):
        length=len(self)
        inedex=index if index>=0 else length+index
        if(index>=length or index<0):
            return None
        node=self.head.next
        while index:
            node=node.next
            index-=1
        return node
    
    def insert(self,index,key):
        length=len(self)
        if(abs(index+1)>length):    
            return False
        index=index if index>=0 else index+1+length
        next_node=self.get(index)
        if(next_node):
            node=Node(key)
            pre_node=next_node.prev
            pre_node.next=node
            node.prev=pre_node
            node.next=next_node
            next_node.prev=node
            return node
    
    def delete(self, index):
        node = self.get(index)
        if node:
            node.prev.next = node.next
            node.next.prev = node.prev
            return True
        return False
        
    def __len__(self):
        length = 0
        node = self.head
        while node.next != self.tail:
            length += 1
            node = node.next
        return length    

    def clear(self):
        self.head.next = self.tail
        self.tail.pre = self.head
        
    def set(self, index, data):
        node = self.get(index)
        if node:
            node.data = data
        return node
    
    def show(self, order=1):
        if order >= 0:
            node = self.head.next
            while node is not self.tail:
                print(node.key, end=" ")
                node = node.next
        else:
            node = self.tail.prev
            while node is not self.head:
                print(node.key, end=" ")
                node = node.prev
        print()    
    
    
def main():
    ls=DoubleLinkedList()
    print(len(ls))
    ls.append(1)
    ls.append(2)
    ls.append(3)
    ls.append(4)
    ls.show(1)
    print(len(ls))
    print(ls.get(0).key)
    ls.set(0, 10)
    ls.show()
    ls.insert(1, -2)
    ls.show()
    ls.delete(-2)
    ls.show()
    ls.show()
    ls.clear()
    ls.show()

if(__name__=='__main__'):
    main()
