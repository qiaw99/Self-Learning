import numpy
import scipy.special
import matplotlib.pyplot

#%matplotlib inline

# neural network class definition
class neuralNetwork:
    # initialise the neural network
    def __init__(self, inputnodes, hiddennodes, outputnodes, lerningrate):
        # set number of nodes in each input, hidden, output layer
        self.inodes = inputnodes
        self.hnodes = hiddennodes
        self.onodes = outputnodes
        # lerning rate
        self.lr = lerningrate
        
        """
        link weight matrices, wit and who.
        weights inside the arrays are w_i_j, where link is from node i to node j in the next layer
        w11 w21
        w12 w22 etc
        """
        self.wih = numpy.random.normal(0.0, pow(self.hnodes,-0.5), (self.hnodes, self.inodes))
        self.who = numpy.random.normal(0.0, pow(self.onodes, -0.5), (self.onodes, self.hnodes))
        
        #activation function is the sigmoid function
        self.activation_function = lambda x: scipy.special.expit(x)
        
        pass

    # train the neural network
    def train(self,inputs_list,targets_list):
        #convert inputs list to 2d array
        inputs = numpy.array(inputs_list, ndmin=2).T
        targets = numpy.array(targets_list, ndmin=2).T
        
        #calculate signals into hidden layer
        hidden_inputs = numpy.dot(self.wih,inputs)
        #calculate the signals emerging from hidden layer
        hidden_outputs = self.activation_function(hidden_inputs)
        
        #calculate signals into final output layer
        

    # query the neural network
    def query(self):
        pass

input_nodes = 3
hidden_nodes = 3
output_nodes = 3
learning_rate = 0.5

#create the instance
n = neuralNetwork(input_nodes, hidden_nodes, output_nodes, learning_rate)









