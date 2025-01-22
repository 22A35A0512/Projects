class Bank:
    def __init__(self):
        self.d={}
    def createacc(self,name,password):
        if name not in self.d:
            self.d[name]=[0,password]
        else:
            print("name already exist")
            return
        print(f"new account created with account number {id(self.d[name])}")
    def deposit(self,name,amount,password):
            self.d[name][0]+=amount
            print("amount is added")
    def withdraw(self,name,amount,password):
            if self.d[name]>=amount:
                print("withdrawl successful")
                self.d[name]-=amount
                return
            else:
                print("insufficient balance")
                return
    def checkbal(self,name,password):
           print(f"your balance is {self.d[name][0]}")
    def accdetails(self,name,password):
            print(f"account holder name: {name}")
            print(f"account secret pin: {self.d[name][1]}")
            print(f"account number: {id(self.d[name])}")
            print(f"your balance is {self.d[name][0]}")
            
b=Bank()
while True:
    print("OPTIONS: ")
    print("1.create an account")
    print("2.cash deposit")
    print("3.cash withdraw")
    print("4.check balance")
    print("5.account details")
    print("6.exit")
    print("enter a number among the above options")
    i=int(input())
    if i==1:
        name=input("enter your name: ")
        password=input("enter a password for secure banking: ")
        b.createacc(name,password)
    elif i==2:
        name=input("enter your name: ")
        password=input("enter the password associated with your account: ")
        if name not in b.d:
            print("create an account first")
        elif b.d[name][1]!=password:
            print("password is not valid")
        else:
            amount=int(input("enter the amount to be deposited: "))
            b.deposit(name,amount,password)
    elif i==3:
        name=input("enter your name: ")
        password=input("enter the password associated with your account: ")
        if name not in b.d:
            print("create an account first")
        elif b.d[name][1]!=password:
            print("password is not valid")
        else:
            amount=int(input("enter the amount to be withdrawn: "))
            b.withdraw(name,amount,password)
    elif i==4:
        name=input("enter your name: ")
        password=input("enter the password associated with your account: ")
        if name not in b.d:
            print("create an account first")
        elif b.d[name][1]!=password:
            print("password is not valid")
        else:
            b.checkbal(name,password)
    elif i==5:
        name=input("enter your name: ")
        password=input("enter the password associated with your account: ")
        if name not in b.d:
            print("create an account first")
        elif b.d[name][1]!=password:
            print("password is not valid")
        else:
            b.accdetails(name,password)
    elif i==6:
        print("thank you for banking")
        break
    else:
        print("invalid option choose the correct option")
